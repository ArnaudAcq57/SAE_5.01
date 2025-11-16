package com.example.sae_501.ml

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.image.ops.ResizeWithCropOrPadOp

/**
 * Classe pour gérer la détection et la classification d'objets avec TensorFlow Lite
 */
class ObjectDetector(private val context: Context) {

    private var interpreter: Interpreter? = null
    private var labels: List<String> = emptyList()

    private val inputSize = 224
    private val maxResults = 5

    companion object {
        private const val TAG = "ObjectDetector"
        private const val MODEL_FILE = "model.tflite"
        private const val LABELS_FILE = "labels.txt"
    }

    /**
     * Initialise le modèle TensorFlow Lite
     */
    fun initialize() {
        try {
            val model = FileUtil.loadMappedFile(context, MODEL_FILE)
            val options = Interpreter.Options().apply {
                setNumThreads(4)
            }
            interpreter = Interpreter(model, options)
            labels = FileUtil.loadLabels(context, LABELS_FILE)
            Log.d(TAG, "Modèle initialisé. ${labels.size} catégories.")
        } catch (e: Exception) {
            Log.e(TAG, "Erreur initialisation modèle", e)
            throw e
        }
    }

    /**
     * Classifie une image
     */
    fun classifyImage(bitmap: Bitmap): List<Classification> {
        if (interpreter == null) {
            throw IllegalStateException("Modèle non initialisé")
        }

        try {
            val tensorImage = preprocessImage(bitmap)
            val outputArray = Array(1) { FloatArray(labels.size) }
            interpreter?.run(tensorImage.buffer, outputArray)
            return processOutput(outputArray[0])
        } catch (e: Exception) {
            Log.e(TAG, "Erreur classification", e)
            return emptyList()
        }
    }

    private fun preprocessImage(bitmap: Bitmap): TensorImage {
        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeWithCropOrPadOp(inputSize, inputSize))
            .add(ResizeOp(inputSize, inputSize, ResizeOp.ResizeMethod.BILINEAR))
            .build()

        var tensorImage = TensorImage.fromBitmap(bitmap)
        tensorImage = imageProcessor.process(tensorImage)
        return tensorImage
    }

    private fun processOutput(output: FloatArray): List<Classification> {
        val classifications = output.mapIndexed { index, confidence ->
            Classification(
                label = if (index < labels.size) labels[index] else "Unknown",
                confidence = confidence,
                index = index
            )
        }
        return classifications.sortedByDescending { it.confidence }.take(maxResults)
    }

    fun getInputSize(): Int = inputSize
    fun getNumberOfCategories(): Int = labels.size
    fun getAllLabels(): List<String> = labels

    fun close() {
        interpreter?.close()
        interpreter = null
        Log.d(TAG, "Modèle fermé")
    }
}
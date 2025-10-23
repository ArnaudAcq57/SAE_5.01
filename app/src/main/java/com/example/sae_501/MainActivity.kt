package com.example.sae_501

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.sae_501.ml.ObjectDetector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var objectDetector: ObjectDetector
    private lateinit var resultTextView: TextView
    private lateinit var testButton: Button

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialiser les vues
        resultTextView = findViewById(R.id.resultTextView)
        testButton = findViewById(R.id.testButton)

        // Initialiser le détecteur
        initializeDetector()

        // Configurer le bouton de test
        testButton.setOnClickListener {
            testClassification()
        }
    }

    private fun initializeDetector() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                objectDetector = ObjectDetector(applicationContext)
                objectDetector.initialize()

                withContext(Dispatchers.Main) {
                    Log.d(TAG, "Détecteur initialisé avec succès")
                    resultTextView.text = "✅ Modèle chargé!\n${objectDetector.getNumberOfCategories()} catégories disponibles.\n\nAppuyez sur 'Tester' pour commencer."
                    testButton.isEnabled = true
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e(TAG, "Erreur initialisation", e)
                    resultTextView.text = "Erreur: ${e.message}"
                }
            }
        }
    }

    private fun testClassification() {
        testButton.isEnabled = false
        resultTextView.text = "Classification en cours..."

        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Créer une image de test simple (200x200 pixels bleus)
                val testBitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
                testBitmap.eraseColor(android.graphics.Color.BLUE)

                // Mesurer le temps d'inférence
                val startTime = System.currentTimeMillis()
                val results = objectDetector.classifyImage(testBitmap)
                val inferenceTime = System.currentTimeMillis() - startTime

                withContext(Dispatchers.Main) {
                    displayResults(results, inferenceTime)
                    testButton.isEnabled = true
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e(TAG, "Erreur classification", e)
                    resultTextView.text = "Erreur: ${e.message}"
                    testButton.isEnabled = true
                }
            }
        }
    }

    private fun displayResults(results: List<com.example.sae_501.ml.Classification>, inferenceTime: Long) {
        if (results.isEmpty()) {
            resultTextView.text = "Aucun résultat"
            return
        }

        val resultText = buildString {
            appendLine("✅ Classification réussie!\n")
            appendLine("⏱️ Temps d'inférence: ${inferenceTime}ms\n")
            appendLine("📊 Top 5 résultats:\n")

            results.take(5).forEachIndexed { index, classification ->
                appendLine("${index + 1}. ${classification.label}")
                appendLine("   Confiance: ${classification.getConfidencePercentage()}%")
                if (index < results.size - 1) appendLine()
            }
        }

        resultTextView.text = resultText
        Log.d(TAG, "Résultats: $resultText")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::objectDetector.isInitialized) {
            objectDetector.close()
        }
    }
}
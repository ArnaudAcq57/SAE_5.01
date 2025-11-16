package com.example.sae_501.ml

/**
 * Représente le résultat d'une classification d'objet
 */
data class Classification(
    val label: String,
    val confidence: Float,
    val index: Int
) {
    /**
     * Retourne la confiance en pourcentage
     */
    fun getConfidencePercentage(): Int {
        return (confidence * 100).toInt()
    }

    /**
     * Vérifie si la confiance est suffisante
     */
    fun isReliable(threshold: Float = 0.5f): Boolean {
        return confidence >= threshold
    }

    override fun toString(): String {
        return "$label: ${getConfidencePercentage()}%"
    }
}
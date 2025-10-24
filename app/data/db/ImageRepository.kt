import android.content.Context
import com.votreprojet.app.data.db.AppDatabase
import com.votreprojet.app.data.db.Category
import com.votreprojet.app.data.db.Image
import com.votreprojet.app.data.db.TrainingData
import java.util.Date

class ImageRepository(context: Context) {

    private val imageDao = AppDatabase.getDatabase(context).imageDao()
    private val categoryDao = AppDatabase.getDatabase(context).categoryDao()

    // --- Opérations sur les Catégories ---

    suspend fun insertCategory(name: String, description: String? = null): Long {
        return categoryDao.insert(Category(name = name, description = description))
    }

    suspend fun getCategoryIdByName(name: String): Int? {
        return categoryDao.getIdByName(name)
    }

    fun getAllCategories(): List<Category> {
        return categoryDao.getAll()
    }

    // --- Opérations sur les Images ---

    suspend fun insertImage(filePath: String, categoryName: String): Long {
        // 1. Trouver ou créer la catégorie
        var categoryId = getCategoryIdByName(categoryName)
        if (categoryId == null) {
            // Insérer la nouvelle catégorie et récupérer son ID
            val newId = insertCategory(categoryName)
            categoryId = newId.toInt()
        }

        // 2. Insérer l'image avec le bon ID de catégorie
        val image = Image(
            filePath = filePath,
            categoryId = categoryId,
            uploadDate = Date()
        )
        return imageDao.insert(image)
    }

    // Utilisé pour mettre à jour une image avec les résultats du modèle d'IA
    suspend fun updateImagePrediction(imageId: Int, result: String, confidence: Double) {
        val image = imageDao.getById(imageId)
        if (image != null) {
            val updatedImage = image.copy(
                predictionResult = result,
                predictionConfidence = confidence
            )
            imageDao.update(updatedImage)
        }
    }

    // Renvoie l'ensemble de données prêt pour l'entraînement/l'évaluation de l'IA
    fun getTrainingDataset(): List<TrainingData> {
        return imageDao.getTrainingData()
    }
}
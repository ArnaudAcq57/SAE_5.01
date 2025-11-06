import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.Date

@Entity(
    tableName = "images",
    // Définit la relation "un-à-plusieurs" avec la table Category
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"], // Colonne de la table Category
            childColumns = ["categoryId"],  // Colonne de cette table (Image)
            onDelete = ForeignKey.CASCADE    // Si une catégorie est supprimée, les images associées le sont aussi
        )
    ]
)
data class Image(
    @PrimaryKey(autoGenerate = true)
    val imageId: Int = 0,

    val filePath: String,

    // Clé étrangère vers la Category, obligatoire pour l'entraînement
    val categoryId: Int,

    val uploadDate: Date,

    // Résultats de l'IA (peuvent être NULL avant la prédiction)
    val predictionResult: String? = null,
    val predictionConfidence: Double? = null
)
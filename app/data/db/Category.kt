import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryId: Int = 0, // Initialisation à 0 pour l'auto-génération

    val name: String,

    // La description n'est pas obligatoire
    val description: String? = null
)
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Category::class, Image::class],
    version = 1, // Assurez-vous que la version est incrémentée lors des migrations
    exportSchema = false // Typiquement false pour les projets simples
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    // Déclaration des DAOs
    abstract fun imageDao(): ImageDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile // Rend l'instance visible immédiatement par tous les threads
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Empêche plusieurs threads d'accéder au bloc de code en même temps
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "sae_database" // Nom de votre fichier de base de données
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
import androidx.room.*
import androidx.lifecycle.LiveData

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(image: Image): Long

    @Update
    suspend fun update(image: Image)


    @Query("""
        SELECT 
            I.filePath, 
            C.name AS categoryLabel 
        FROM images I
        JOIN categories C ON I.categoryId = C.categoryId
    """)
    fun getTrainingData(): List<TrainingData>

    @Query("SELECT * FROM images WHERE imageId = :id")
    suspend fun getById(id: Int): Image?
}
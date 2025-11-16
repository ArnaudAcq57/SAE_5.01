import androidx.room.*

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: Category): Long

    @Query("SELECT * FROM categories ORDER BY name ASC")
    fun getAll(): List<Category>

    @Query("SELECT categoryId FROM categories WHERE name = :name LIMIT 1")
    suspend fun getIdByName(name: String): Int?

    @Query("SELECT name FROM categories WHERE categoryId = :id LIMIT 1")
    suspend fun getNameById(id: Int): String?
}
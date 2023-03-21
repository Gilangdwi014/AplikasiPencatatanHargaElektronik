package id.ac.unpas.functionalcompose.persistences
import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.functionalcompose.model.DataElektronik

@Dao
interface DataElektronikDao {
    @Query("SELECT * FROM DataElektronik")
    fun loadAll(): LiveData<List<DataElektronik>>
    @Query("SELECT * FROM DataElektronik WHERE id = :id")
    fun find(id: String): DataElektronik?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataElektronik)
    @Delete
    fun delete(item: DataElektronik)
}
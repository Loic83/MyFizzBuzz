package data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import domain.model.ResultEntity

@Dao
interface ResultDao {

    @Query("SELECT * FROM ResultEntity")
    fun getResults(): LiveData<List<ResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(note: ResultEntity)

    @Query("DELETE FROM ResultEntity")
    fun deleteAllResults()

}
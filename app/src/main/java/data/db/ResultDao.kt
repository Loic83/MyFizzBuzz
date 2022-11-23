package data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import domain.model.ResultEntity

@Dao
interface ResultDao {

    @Query("SELECT * FROM ResultEntity LIMIT :limit")
    fun getResults(limit : Int): LiveData<List<ResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: ResultEntity)

    @Query("DELETE FROM ResultEntity")
    fun deleteAllResults()

}
package domain.repository

import androidx.lifecycle.LiveData
import domain.model.ResultEntity

interface ResultRepository {

    suspend fun insertResult(result: ResultEntity)

    suspend fun getResults(limit: Int): LiveData<List<ResultEntity>>

    suspend fun deleteAllResults()

}
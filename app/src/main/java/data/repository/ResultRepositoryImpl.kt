package data.repository

import androidx.lifecycle.LiveData
import data.db.ResultDao
import domain.model.ResultEntity
import domain.repository.ResultRepository

class ResultRepositoryImpl(
    private val dao: ResultDao
) : ResultRepository {

    override suspend fun insertResult(result: ResultEntity) {
        return dao.insertResult(result)
    }

    override suspend fun getResults(): LiveData<List<ResultEntity>> {
        return dao.getResults()
    }

    override suspend fun deleteAllResults() {
        return dao.deleteAllResults()
    }

}
package domain.use_case

import androidx.lifecycle.LiveData
import domain.model.ResultEntity
import domain.repository.ResultRepository

class GetResults (private val repository: ResultRepository) {

    suspend operator fun invoke(limit : Int): LiveData<List<ResultEntity>> {
        return repository.getResults(limit)
    }

}
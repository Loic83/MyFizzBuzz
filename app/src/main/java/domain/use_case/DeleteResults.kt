package domain.use_case

import domain.repository.ResultRepository

class DeleteResults (private val repository: ResultRepository) {

    suspend operator fun invoke() {
        return repository.deleteAllResults()
    }

}
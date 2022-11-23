package domain.use_case

import domain.model.Input
import domain.model.InvalidInputException
import domain.model.ResultEntity
import domain.repository.ResultRepository
import domain.util.Calculation

class AddResult (private val repository: ResultRepository) {

    @Throws(InvalidInputException::class)
    suspend operator fun invoke(input: Input) {
        if(input.str1.isBlank() || input.str2.isBlank() ||
            input.limit.toString().isBlank() || input.int1.toString().isBlank() ||
            input.int2.toString().isBlank()) {
            throw InvalidInputException("Un champ est manquant, veuillez corriger")
        }

        if (input.limit > 1000000) {
            throw InvalidInputException("Vous avez dépassé la limite")
        }

        val arrayResult = Calculation.calculResult(input)

        for (i in 0 until arrayResult.size){
            repository.insertResult(ResultEntity(arrayResult[i].first,arrayResult[i].second))
        }

    }

}
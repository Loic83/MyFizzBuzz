package domain.use_case

data class ResultUseCases(
    val getResults: GetResults,
    val addResult: AddResult,
    val deleteResults: DeleteResults
)

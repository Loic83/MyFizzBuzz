package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.use_case.GetResults
import domain.use_case.ResultUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val resultUseCases: ResultUseCases
): ViewModel() {

    val results: GetResults = resultUseCases.getResults

    suspend fun deleteResults () {
        resultUseCases.deleteResults.invoke()
    }
}
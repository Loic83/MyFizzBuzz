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

    fun deleteResults () {
        viewModelScope.launch {
            resultUseCases.deleteResults
        }
    }

    val results: GetResults = resultUseCases.getResults


}
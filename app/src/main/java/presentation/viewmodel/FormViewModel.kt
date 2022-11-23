package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.model.Input
import domain.model.InvalidInputException
import domain.use_case.ResultUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val resultUseCases: ResultUseCases
) : ViewModel() {

    fun addResult (input: Input) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    resultUseCases.addResult(input)
                } catch (e: InvalidInputException) {

                }
            }
        }
    }
}
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

    fun onValidation(str1 : String, str2 : String, int1 : String, int2 : String, limit : String): Boolean {

        return !(str1.isBlank() || str2.isBlank() || limit.isBlank() || int1.isBlank() ||
                int2.isBlank()  || limit.toLong() > 50000 || int1.toLong() > 50000
                || int2.toLong() > 50000)

    }
}
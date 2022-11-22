package presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import domain.model.Input
import domain.use_case.ResultUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val resultUseCases: ResultUseCases
) : ViewModel() {

    fun addNote (input: Input) {
        viewModelScope.launch {
            resultUseCases.addResult (input)
        }
    }

}
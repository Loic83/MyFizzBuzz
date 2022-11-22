package presentation.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
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

    fun addNote (input: Input) {
        viewModelScope.launch {
            try {
                resultUseCases.addResult (input)
            } catch (e: InvalidInputException) {

            }
        }
    }
}
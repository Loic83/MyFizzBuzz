package presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.myfizzbuzz.R
import dagger.hilt.android.AndroidEntryPoint
import domain.model.Input
import presentation.viewmodel.FormViewModel



@AndroidEntryPoint
class FormActivity : AppCompatActivity() {

    private lateinit var viewModel : FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val editInt1: EditText = findViewById(R.id.editTextInt1)
        val editInt2: EditText = findViewById(R.id.editTextInt2)
        val editLimit: EditText = findViewById(R.id.editTextLimit)
        val editStr1: EditText = findViewById(R.id.editTextStr1)
        val editStr2: EditText = findViewById(R.id.editTextStr2)
        val btnValider: Button = findViewById(R.id.btn_valider)

        btnValider.setOnClickListener {
            val input = Input(editStr1.text.toString(),
                editStr2.text.toString(),
                editLimit.text.toString().toInt(),
                editInt1.text.toString().toInt(),
                editInt2.text.toString().toInt())
            viewModel = ViewModelProvider(this)[FormViewModel::class.java]
            viewModel.addNote(input)

            startActivity(Intent(this,ListActivity::class.java))
        }
    }
}
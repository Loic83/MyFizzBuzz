package presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myfizzbuzz.R
import dagger.hilt.android.AndroidEntryPoint
import domain.model.Input
import domain.model.InvalidInputException
import kotlinx.coroutines.launch
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
        val progressBar : ProgressBar = findViewById(R.id.progress)
        val tvCalcul : TextView = findViewById(R.id.tv_calcul)

        btnValider.setOnClickListener {

            val str1 : String = editStr1.text.toString()
            val str2 : String = editStr2.text.toString()
            val int1 : String = editInt1.text.toString()
            val int2 : String = editInt2.text.toString()
            val limit : String = editLimit.text.toString()

            viewModel = ViewModelProvider(this)[FormViewModel::class.java]

            val validation : Boolean = viewModel.onValidation(str1,str2, int1, int2, limit)

            if (!validation) {
               Toast.makeText(this,getString(R.string.saisie_a_refaire),Toast.LENGTH_SHORT).show()
           } else {
               tvCalcul.visibility = View.VISIBLE
               progressBar.visibility = View.VISIBLE
               progressBar.setProgress(50,true)

               val input = Input(editStr1.text.toString(),
                   editStr2.text.toString(),
                   editLimit.text.toString().toInt(),
                   editInt1.text.toString().toInt(),
                   editInt2.text.toString().toInt())

               val job = lifecycleScope.launch {
                       try {
                           viewModel.addResult(input)
                       } catch (e: InvalidInputException) {

                       }
                    }

               if(job.isCompleted) {
                   progressBar.visibility = View.GONE
                   tvCalcul.visibility = View.GONE

                   val intent = Intent(this,ListActivity::class.java)
                   intent.putExtra("limit",editLimit.text.toString())
                   startActivity(intent)
               }
           }
        }
    }
}
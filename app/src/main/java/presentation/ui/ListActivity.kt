package presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfizzbuzz.R
import com.example.myfizzbuzz.presentation.adapter.FormListAdapter
import dagger.hilt.android.AndroidEntryPoint
import domain.model.ResultEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import presentation.viewmodel.ListViewModel

@AndroidEntryPoint
class ListActivity : AppCompatActivity() {

    private lateinit var resultsAdapter: FormListAdapter
    private lateinit var results:MutableList<ResultEntity>
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        results = mutableListOf()
        resultsAdapter = FormListAdapter(results)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = resultsAdapter
        }

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        lifecycleScope.launch {
            viewModel.results.invoke().observe(this@ListActivity, Observer {newResults -> updateResults(newResults!!)})
        }
    }

    private fun updateResults(newResults: List<ResultEntity>) {
        results.clear()
        results.addAll(newResults)
        resultsAdapter.notifyDataSetChanged()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        lifecycleScope.launch {
            withContext( Dispatchers.IO) {
                viewModel.deleteResults()
            }
        }

    }
}
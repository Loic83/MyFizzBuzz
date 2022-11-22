package com.example.myfizzbuzz.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfizzbuzz.R
import domain.model.ResultEntity

class FormListAdapter (private val results : List<ResultEntity> )
    : RecyclerView.Adapter<FormListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val resultId = itemView.findViewById<TextView>(R.id.idResult)!!
        val resultTv = itemView.findViewById<TextView>(R.id.result)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_result,parent,false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val result = results[position]
        with(holder) {
            resultId.text = "ID : "+result.id.toString()
            resultTv.text = "Result : "+result.result
        }

    }

    override fun getItemCount(): Int = results.size
}
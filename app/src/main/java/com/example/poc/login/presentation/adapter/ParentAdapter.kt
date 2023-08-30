package com.example.poc.login.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.poc.R
import com.example.poc.login.data.model.ParentModel


class ParentAdapter(private val parentData: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcy_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parentData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(parentData[position])

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(parentItem: ParentModel) {
            itemView.findViewById<TextView>(R.id.transaction_id).text = parentItem.tranValue

            val childRecyclerView = itemView.findViewById<RecyclerView>(R.id.child_rcy)
            childRecyclerView.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
            val childAdapter = ChildAdapter(parentItem.childData)
            childRecyclerView.adapter = childAdapter
        }


    }
}
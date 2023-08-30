package com.example.poc.login.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.poc.R
import com.example.poc.login.data.model.ChildModel

class ChildAdapter(private val childData:List<ChildModel>):RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.nested_rcy,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(childData[position])
    }

    override fun getItemCount(): Int {
        return childData.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(childItem: ChildModel) {
            itemView.findViewById<TextView>(R.id.price).text = childItem.price
        }


    }
}
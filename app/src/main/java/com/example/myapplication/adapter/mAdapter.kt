package com.example.myapplication.adapter

import android.provider.ContactsContract.RawContacts.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bean.Story
import com.example.myapplication.R

class mAdapter() : ListAdapter<String, mAdapter.OneHolder>(object : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return OneHolder((itemView))
    }

    override fun onBindViewHolder(holder: OneHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }
    inner class OneHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.rv_text)

        fun bind(itemData: String ){
            textView.text =itemData
        }

    }
}
package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.bean.Story
import com.example.myapplication.bean.Test

class TestAdapter(): ListAdapter<Test, TestAdapter.SimpleHolder>(object : DiffUtil.ItemCallback<Test>(){
    override fun areItemsTheSame(oldItem: Test, newItem: Test): Boolean {
        return oldItem.num== newItem.num
    }

    override fun areContentsTheSame(oldItem: Test, newItem: Test): Boolean {
        return oldItem.num == newItem.num
    }
}){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  SimpleHolder{
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_test, parent, false)
        return SimpleHolder((itemView))
    }

    override fun onBindViewHolder(holder: SimpleHolder, position: Int) {
        val itemData = getItem(position)

    }


    inner class SimpleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}
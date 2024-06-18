package Adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import bean.Story
import com.example.myapplication.R

class mAdapter() : ListAdapter<Story, mAdapter.OneHolder>(object : DiffUtil.ItemCallback<Story>(){
    override fun areItemsTheSame(oldItem: Story, newItem:Story): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
        return oldItem.name == newItem.name
    }
}){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneHolder{
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return OneHolder((itemView))
    }

    override fun onBindViewHolder(holder: OneHolder, position: Int) {
        val itemData = getItem(position)
        holder.bind(itemData)
    }
    inner class OneHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.Mtest)

        fun bind(itemData: Story) {
            textView.text = itemData.name.toString()
        }

    }
}
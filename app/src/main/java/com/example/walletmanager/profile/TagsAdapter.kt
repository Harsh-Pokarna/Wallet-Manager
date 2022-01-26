package com.example.walletmanager.profile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walletmanager.R
import com.example.walletmanager.pojos.Tag

class TagsAdapter(private var listOfTags: List<Tag>, private val listener: OnClicked) : RecyclerView.Adapter<TagsAdapter.TagsViewHolder>() {

    inner class TagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tagNameTextView: TextView = itemView.findViewById(R.id.tag_name)
        private val deleteTagButton: ImageButton = itemView.findViewById(R.id.delete_tag_button)

        fun bind(tag: Tag) {
            tagNameTextView.text = tag.tagName

            deleteTagButton.setOnClickListener {
                Log.e("TAG", "bind: delete clicked")
                listener.onDeleteClicked(tag)
            }
        }
    }

    fun addData(listOfTags: List<Tag>) {
        this.listOfTags = listOfTags
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        return TagsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tag, parent, false))
    }

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.bind(listOfTags[position])
    }

    override fun getItemCount(): Int {
        return listOfTags.size
    }

    interface OnClicked {
        fun onItemClicked(tag: Tag)
        fun onDeleteClicked(tag: Tag)
    }
}
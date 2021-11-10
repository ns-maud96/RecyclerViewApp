package com.example.recyclerview.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DialogAdapter : RecyclerView.Adapter<DialogViewHolder>() {

    private var itemClickListener: ((VideoCard) -> Unit)? = null
    private var videoCardModels: List<VideoCard> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val viewHolder = DialogViewHolder.from(parent)
        viewHolder.setItemClickListener { videoCard ->
            itemClickListener?.invoke(videoCard)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        holder.bindView(videoCardModels[position])
    }

    override fun getItemCount() = videoCardModels.size

    fun submitList(data: List<VideoCard>) {
        videoCardModels = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (VideoCard) -> Unit) {
        itemClickListener = listener
    }
}
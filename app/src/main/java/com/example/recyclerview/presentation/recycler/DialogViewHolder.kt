package com.example.recyclerview.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.item_layout.view.*

class DialogViewHolder(item: View) : RecyclerView.ViewHolder(item) {

    companion object {
        fun from(parent: ViewGroup): DialogViewHolder {
            return DialogViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.item_layout, parent, false)
            )
        }
    }

    private var itemClickListener: ((VideoCard) -> Unit)? = null
    private val itemTextView by lazy { itemView.model }

    fun bindView(item: VideoCard) {
        itemTextView.text = item.model
        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemClickListener(listener: ((VideoCard) -> Unit)) {
        itemClickListener = listener
    }
}
package com.example.starbucks.ui.whatsnew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.WhatsNewItem
import com.example.starbucks.databinding.ItemWhatsNewBinding

class WhatsNewAdapter: ListAdapter<WhatsNewItem, WhatsNewAdapter.WhatsNewViewHolder>(
    WhatsNewDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WhatsNewViewHolder {
        val binding = ItemWhatsNewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WhatsNewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WhatsNewViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    class WhatsNewViewHolder(private val binding: ItemWhatsNewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(whatsNewItem: WhatsNewItem) {
            binding.item = whatsNewItem
        }

    }

    private object WhatsNewDiffUtil : DiffUtil.ItemCallback<WhatsNewItem>() {

        override fun areItemsTheSame(oldItem: WhatsNewItem, newItem: WhatsNewItem) = oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: WhatsNewItem, newItem: WhatsNewItem) = oldItem == newItem

    }


}
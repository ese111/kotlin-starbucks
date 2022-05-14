package com.example.starbucks.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.HomeData
import com.example.starbucks.databinding.ItemPopularMenuItemBinding

class PopularMenuAdapter :
    ListAdapter<HomeData.PopularMenu.PopularMenuItem, PopularMenuAdapter.PopularMenuItemViewHolder>(
        PopularMenuDiffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMenuItemViewHolder {
        return PopularMenuItemViewHolder(
            ItemPopularMenuItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PopularMenuItemViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    class PopularMenuItemViewHolder(private val binding: ItemPopularMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menu: HomeData.PopularMenu.PopularMenuItem, position: Int) {
            binding.item = menu
            val rank = position + 1
            binding.tvRank.text = rank.toString()
        }

    }

    private object PopularMenuDiffUtil :
        DiffUtil.ItemCallback<HomeData.PopularMenu.PopularMenuItem>() {

        override fun areItemsTheSame(
            oldItem: HomeData.PopularMenu.PopularMenuItem,
            newItem: HomeData.PopularMenu.PopularMenuItem
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: HomeData.PopularMenu.PopularMenuItem,
            newItem: HomeData.PopularMenu.PopularMenuItem
        ) = oldItem == newItem

    }

}
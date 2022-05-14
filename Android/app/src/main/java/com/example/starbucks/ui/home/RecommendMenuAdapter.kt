package com.example.starbucks.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.HomeData
import com.example.starbucks.databinding.ItemRecommendMeunItemBinding

class RecommendMenuAdapter: ListAdapter<HomeData.RecommendMenu.RecommendMenuItem, RecommendMenuAdapter.MenuViewHolder>(MenuDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(ItemRecommendMeunItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MenuViewHolder(private val binding: ItemRecommendMeunItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(menuItem: HomeData.RecommendMenu.RecommendMenuItem) {
            binding.item = menuItem
        }

    }

    private object MenuDiffUtil: DiffUtil.ItemCallback<HomeData.RecommendMenu.RecommendMenuItem>() {

        override fun areItemsTheSame(
            oldItem: HomeData.RecommendMenu.RecommendMenuItem,
            newItem: HomeData.RecommendMenu.RecommendMenuItem
        ) = oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(
            oldItem: HomeData.RecommendMenu.RecommendMenuItem,
            newItem: HomeData.RecommendMenu.RecommendMenuItem
        ) = oldItem == newItem

    }

}
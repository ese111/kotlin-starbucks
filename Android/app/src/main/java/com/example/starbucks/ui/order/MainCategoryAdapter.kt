package com.example.starbucks.ui.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.CategoryMenuData
import com.example.starbucks.databinding.ItemMainCategoryBinding

class MainCategoryAdapter: ListAdapter<CategoryMenuData, MainCategoryAdapter.MainCategoryViewHolder>(MainCategoryDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoryViewHolder {
        return MainCategoryViewHolder(ItemMainCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MainCategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MainCategoryViewHolder(private val binding: ItemMainCategoryBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: CategoryMenuData) {
            binding.item = data
        }

    }

    private object MainCategoryDiffUtil: DiffUtil.ItemCallback<CategoryMenuData>() {

        override fun areItemsTheSame(
            oldItem: CategoryMenuData,
            newItem: CategoryMenuData
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CategoryMenuData,
            newItem: CategoryMenuData
        ) = oldItem == newItem

    }
}
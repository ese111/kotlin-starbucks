package com.example.starbucks.ui.order.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.DetailCategory
import com.example.starbucks.databinding.ItemDetailCategoryBinding
import com.example.starbucks.ui.order.CategoryClickListener

class DetailCategoryAdapter(private val listener: CategoryClickListener) :
    ListAdapter<DetailCategory, DetailCategoryAdapter.DetailCategoryViewHolder>(
        DetailCategoryDiffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DetailCategoryViewHolder(ItemDetailCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: DetailCategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DetailCategoryViewHolder(private val binding: ItemDetailCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(data: DetailCategory) {
                binding.item = data
                setOnClickViewHolder(data.id)
            }

            private fun setOnClickViewHolder(id: Int) {
                itemView.setOnClickListener {
                    listener.moveDetailPage(id)
                }
            }
    }

    private object DetailCategoryDiffUtil : DiffUtil.ItemCallback<DetailCategory>() {

        override fun areContentsTheSame(oldItem: DetailCategory, newItem: DetailCategory) =
            oldItem.id == newItem.id

        override fun areItemsTheSame(oldItem: DetailCategory, newItem: DetailCategory) =
            oldItem == newItem
    }

}
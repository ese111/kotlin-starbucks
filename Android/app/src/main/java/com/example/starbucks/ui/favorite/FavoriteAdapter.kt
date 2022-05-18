package com.example.starbucks.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.R
import com.example.starbucks.data.vo.FavoriteMenu
import com.example.starbucks.databinding.ItemFavoriteBinding

class FavoriteAdapter(private val remove: (FavoriteMenu) -> (Unit)) :
    ListAdapter<FavoriteMenu, FavoriteAdapter.FavoriteViewHolder>(FavoriteDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: FavoriteMenu) {
            binding.item = data
            setOnClickHeart(data)
        }

        private fun setOnClickHeart(data: FavoriteMenu) {
            binding.cbHeart.setOnClickListener {
                binding.cbHeart.isChecked = false
                remove(data)
            }
        }
    }

    private object FavoriteDiffUtil : DiffUtil.ItemCallback<FavoriteMenu>() {
        override fun areItemsTheSame(oldItem: FavoriteMenu, newItem: FavoriteMenu) =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: FavoriteMenu, newItem: FavoriteMenu) =
            oldItem == newItem

    }
}
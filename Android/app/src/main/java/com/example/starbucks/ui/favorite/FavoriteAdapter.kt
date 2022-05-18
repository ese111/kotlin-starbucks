package com.example.starbucks.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.R
import com.example.starbucks.data.vo.FavoriteMenu
import com.example.starbucks.databinding.ItemFavoriteBinding

class FavoriteAdapter :
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

    class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: FavoriteMenu) {
            binding.ivMenuImageInFavorite.setImageDrawable(binding.root.context.getDrawable(R.drawable.ic_baseline_image_24))
            binding.tvTitleInFavoriteKor.text = "아메리카노"
            binding.tvTitleInFavoriteEng.text = "Americano"
            binding.tvPriceInFavorite.text = "4,500원"
        }
    }

    private object FavoriteDiffUtil : DiffUtil.ItemCallback<FavoriteMenu>() {
        override fun areItemsTheSame(oldItem: FavoriteMenu, newItem: FavoriteMenu) =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: FavoriteMenu, newItem: FavoriteMenu) =
            oldItem == newItem

    }
}
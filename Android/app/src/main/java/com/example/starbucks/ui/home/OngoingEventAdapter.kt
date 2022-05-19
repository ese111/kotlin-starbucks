package com.example.starbucks.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starbucks.data.vo.HomeData
import com.example.starbucks.databinding.ItemOngoingEventItemBinding

class OngoingEventAdapter :
    ListAdapter<HomeData.OngoingEvent.OngoingEventItem, OngoingEventAdapter.OngoingEventItemViewHolder>(
        OngoingEventDiffUtil
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OngoingEventItemViewHolder {
        return OngoingEventItemViewHolder(
            ItemOngoingEventItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OngoingEventItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class OngoingEventItemViewHolder(private val binding: ItemOngoingEventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: HomeData.OngoingEvent.OngoingEventItem) {
            binding.item = event
        }

    }

    private object OngoingEventDiffUtil :
        DiffUtil.ItemCallback<HomeData.OngoingEvent.OngoingEventItem>() {
        override fun areItemsTheSame(
            oldItem: HomeData.OngoingEvent.OngoingEventItem,
            newItem: HomeData.OngoingEvent.OngoingEventItem
        ) = oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(
            oldItem: HomeData.OngoingEvent.OngoingEventItem,
            newItem: HomeData.OngoingEvent.OngoingEventItem
        ) = oldItem == newItem
    }

}
package com.example.starbucks.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.starbucks.data.vo.HomeData
import com.example.starbucks.databinding.*

private const val RECOMMEND_LABEL = 0
private const val RECOMMEND_MENU = 1
private const val MAIN_EVENT = 2
private const val SEE_ALL_BTN = 3
private const val ONGOING_EVENT = 4
private const val POPULAR_LABEL = 5
private const val POPULAR_MENU = 6

class HomeAdapter : ListAdapter<HomeData, ViewHolder>(HomeDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {

            RECOMMEND_LABEL -> RecommendLabelViewHolder(
                ItemRecommandLabelBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            RECOMMEND_MENU -> RecommendMenuViewHolder(
                ItemRecommendMenuListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            MAIN_EVENT -> MainEventViewHolder(
                ItemMainEventBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            SEE_ALL_BTN -> SeeAllButtonViewHolder(
                ItemSeeAllBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ONGOING_EVENT -> OngoingEventViewHolder(
                ItemOngoingEventBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            POPULAR_LABEL -> PopularLabelViewHolder(
                ItemPopularMenuLabelBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> PopularMenuViewHolder(
                ItemPopularMenuBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is RecommendLabelViewHolder -> holder.bind(currentList[position] as HomeData.HomeLabel)
            is RecommendMenuViewHolder -> holder.bind(currentList[position] as HomeData.RecommendMenu)
            is MainEventViewHolder -> holder.bind(currentList[position] as HomeData.MainEvent)
            is SeeAllButtonViewHolder -> holder.bind(currentList[position] as HomeData.EventAllViewBtnLabel)
            is OngoingEventViewHolder -> holder.bind(currentList[position] as HomeData.OngoingEvent)
            is PopularLabelViewHolder -> holder.bind(currentList[position] as HomeData.PoplarMenuLabel)
            is PopularMenuViewHolder -> holder.bind(currentList[position] as HomeData.PopularMenu)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> RECOMMEND_LABEL
            1 -> RECOMMEND_MENU
            2 -> MAIN_EVENT
            3 -> SEE_ALL_BTN
            4 -> ONGOING_EVENT
            5 -> POPULAR_LABEL
            else -> POPULAR_MENU
        }
    }

    class RecommendLabelViewHolder(private val binding: ItemRecommandLabelBinding) :
        ViewHolder(binding.root) {

        fun bind(label: HomeData.HomeLabel) {
            binding.item = label
        }
    }

    class RecommendMenuViewHolder(private val binding: ItemRecommendMenuListBinding) :
        ViewHolder(binding.root) {
        fun bind(label: HomeData.RecommendMenu) {
            val adapter = RecommendMenuAdapter()
            binding.rvRecommendMenuList.adapter = adapter
            adapter.submitList(label.list)
        }
    }

    class MainEventViewHolder(private val binding: ItemMainEventBinding) :
        ViewHolder(binding.root) {
        fun bind(event: HomeData.MainEvent) {
            binding.item = event
        }
    }

    class SeeAllButtonViewHolder(private val binding: ItemSeeAllBinding) :
        ViewHolder(binding.root) {
        fun bind(btnLabel: HomeData.EventAllViewBtnLabel) {
            binding.item = btnLabel
        }
    }

    class OngoingEventViewHolder(private val binding: ItemOngoingEventBinding) :
        ViewHolder(binding.root) {
        fun bind(eventList: HomeData.OngoingEvent) {
            val adapter = OngoingEventAdapter()
            binding.rvOngoingEvent.adapter = adapter
            adapter.submitList(eventList.list)
        }
    }

    class PopularLabelViewHolder(private val binding: ItemPopularMenuLabelBinding) :
        ViewHolder(binding.root) {
        fun bind(label: HomeData.PoplarMenuLabel) {
            binding.item = label
        }
    }

    class PopularMenuViewHolder(private val binding: ItemPopularMenuBinding) :
        ViewHolder(binding.root) {
        fun bind(menu: HomeData.PopularMenu) {
            val adapter = PopularMenuAdapter()
            binding.rvPopularMenu.adapter = adapter
            adapter.submitList(menu.list)
        }
    }

    private object HomeDiffUtil : DiffUtil.ItemCallback<HomeData>() {

        override fun areItemsTheSame(oldItem: HomeData, newItem: HomeData) =
            oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(oldItem: HomeData, newItem: HomeData) =
            oldItem == newItem

    }
}
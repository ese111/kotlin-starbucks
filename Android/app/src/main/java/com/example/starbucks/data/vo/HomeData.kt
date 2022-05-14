package com.example.starbucks.data.vo

sealed class HomeData {

    data class HomeLabel(
        val user: String = "얼음jk"
    ) : HomeData()

    data class RecommendMenu(
        val list: List<RecommendMenuItem>
    ) : HomeData() {

        data class RecommendMenuItem(
            val name: String,
            val image: String
        )

    }

    data class MainEvent(
        val imageUrl: String
    ) : HomeData()

    data class EventAllViewBtnLabel(
        val btnLabel: String = "see all"
    ) : HomeData()

    data class OngoingEvent(
        val list: List<OngoingEventItem>
    ) : HomeData() {

        data class OngoingEventItem(
            val imageUrl: String,
            val title: String,
            val description: String
        )

    }

    data class PoplarMenuLabel(
        val label: String = "이 시간대 인기 메뉴",
        val time: String
    ) : HomeData()

    data class PopularMenu(val list: List<PopularMenuItem>) : HomeData() {

        data class PopularMenuItem(
            val id: Int,
            val imageUrl : String,
            val name : String
        )
    }


}

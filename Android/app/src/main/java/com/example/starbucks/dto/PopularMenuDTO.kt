package com.example.starbucks.dto

import com.example.starbucks.data.vo.HomeData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMenuDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("koreanTitle")
    val koreanTitle: String?,
    @SerialName("imageUrl")
    val imageUrl: String?
)

fun List<PopularMenuDTO>.toPopularMenu(): HomeData.PopularMenu {

    val list = mutableListOf<HomeData.PopularMenu.PopularMenuItem>()

    this.forEach {
        val id = requireNotNull(it.id)
        val imageUrl = requireNotNull(it.imageUrl)
        val name = requireNotNull(it.koreanTitle)
        list.add(HomeData.PopularMenu.PopularMenuItem(id, imageUrl, name))
    }

    return HomeData.PopularMenu(list)
}

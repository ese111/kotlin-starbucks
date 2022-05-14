package com.example.starbucks.dto


import com.example.starbucks.data.vo.HomeData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecommendMenuDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("name")
    val name: String?
)

fun List<RecommendMenuDTO>.toRecommendMenu(): HomeData.RecommendMenu {
    val list = mutableListOf<HomeData.RecommendMenu.RecommendMenuItem>()
    this.forEach {
        val name = requireNotNull(it.name)
        val image = requireNotNull(it.imageUrl)
        list.add(HomeData.RecommendMenu.RecommendMenuItem(name, image))
    }
    return HomeData.RecommendMenu(list)
}


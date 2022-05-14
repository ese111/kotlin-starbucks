package com.example.starbucks.dto


import com.example.starbucks.data.vo.HomeData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OngoingEventDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("title")
    val title: String?
)

fun List<OngoingEventDTO>.toOngoingEvent(): HomeData.OngoingEvent {
    val list = mutableListOf<HomeData.OngoingEvent.OngoingEventItem>()

    this.forEach {
        val imageUrl = it.imageUrl.orEmpty()
        val title = requireNotNull(it.title)
        val description = it.description.orEmpty()
        list.add(HomeData.OngoingEvent.OngoingEventItem(imageUrl, title, description))
    }

    return HomeData.OngoingEvent(list)
}
package com.example.starbucks.dto


import com.example.starbucks.common.getRange
import com.example.starbucks.data.vo.HomeData
import kotlinx.serialization.Serializable

@Serializable
data class MainEventDTO(
    val imageUrl: String?,
)

fun MainEventDTO.toMainEvent(): HomeData.MainEvent {
    val imageUrl = requireNotNull(imageUrl)
    return HomeData.MainEvent(imageUrl)
}
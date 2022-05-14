package com.example.starbucks.dto

import com.example.starbucks.data.vo.StartEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StartEventDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("event-products")
    val eventProducts: String?,
    @SerialName("range")
    val range: String?,
    @SerialName("target")
    val target: String?,
    @SerialName("title")
    val title: String?
)

fun StartEventDTO.toStartEvent(): StartEvent {

    val description = requireNotNull(this.description)
    val eventProducts = requireNotNull(this.eventProducts)
    val range = requireNotNull(this.range)
    val target = requireNotNull(this.target)
    val title = requireNotNull(this.title)

    return StartEvent(description, eventProducts, range, target, title)
}

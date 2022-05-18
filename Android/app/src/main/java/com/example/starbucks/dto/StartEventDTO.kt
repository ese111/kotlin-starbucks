package com.example.starbucks.dto

import android.os.Build
import com.example.starbucks.common.getEventRange
import com.example.starbucks.common.toDate
import com.example.starbucks.data.vo.StartEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

@Serializable
data class StartEventDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("endDateTime")
    val endDateTime: String?,
    @SerialName("eventProductName")
    val eventProductName: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("startDateTime")
    val startDateTime: String?,
    @SerialName("target")
    val target: String?,
    @SerialName("title")
    val title: String?
)

fun StartEventDTO.toStartEvent(): StartEvent {
    val description = requireNotNull(this.description)
    val eventProducts = requireNotNull(this.eventProductName)
    val startDateTime = requireNotNull(this.startDateTime)
    val startDate = startDateTime.toDate()
    val endDateTime = requireNotNull(this.endDateTime)
    val endDate = endDateTime.toDate()
    val range = startDate.getEventRange(endDate)
    val target = requireNotNull(this.target)
    val title = requireNotNull(this.title)

    return StartEvent(title, description, range, eventProducts, target)
}

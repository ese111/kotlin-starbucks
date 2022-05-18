package com.example.starbucks.dto

import androidx.annotation.Keep
import com.example.starbucks.data.vo.WhatsNewItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class WhatsNewDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("title")
    val title: String?
)

fun List<WhatsNewDTO>.toWhatsNewList(): List<WhatsNewItem> {
    val whatsNewList = mutableListOf<WhatsNewItem>()

    this.forEach { whatsNew ->
        val title = requireNotNull(whatsNew.title)
        val description = whatsNew.description.orEmpty()
        val image = whatsNew.imageUrl.orEmpty()
        whatsNewList.add(WhatsNewItem(description, image, title))
    }

    return whatsNewList
}



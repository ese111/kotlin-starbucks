package com.example.starbucks.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Category(
    @SerialName("englishName")
    val englishName: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("koreanName")
    val koreanName: String?
)
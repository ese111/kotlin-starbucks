package com.example.starbucks.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderMainCategoryDTO(
    @SerialName("categories")
    val categories: List<Category>?,
    @SerialName("categoryTypes")
    val categoryTypes: List<String>?
)
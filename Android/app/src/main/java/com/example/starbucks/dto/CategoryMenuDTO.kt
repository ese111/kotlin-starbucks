package com.example.starbucks.dto


import android.util.Log
import com.example.starbucks.data.vo.CategoryMenuData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryMenuDTO(
    @SerialName("categories")
    val categories: List<Category>?,
    @SerialName("categoryTypes")
    val categoryTypes: List<String>?
) {

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

}

fun CategoryMenuDTO.toMenuData(): List<CategoryMenuData> {

    val list = mutableListOf<CategoryMenuData>()

    this.categories?.forEach {
        val id = requireNotNull(it.id)
        val korName = requireNotNull(it.koreanName)
        val engName = requireNotNull(it.englishName)
        val image = it.imageUrl.orEmpty()
        list.add(CategoryMenuData(engName, id, image, korName))
        Log.e("TAG", "${it.id}, ${it.koreanName}")
    }

    return list
}
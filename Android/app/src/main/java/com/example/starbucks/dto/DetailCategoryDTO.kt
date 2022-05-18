package com.example.starbucks.dto


import com.example.starbucks.common.toMoney
import com.example.starbucks.data.vo.DetailCategory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailCategoryDTO(
    @SerialName("categoryName")
    val categoryName: String?,
    @SerialName("products")
    val products: List<Product>?
) {
    @Serializable
    data class Product(
        @SerialName("best")
        val best: Boolean?,
        @SerialName("englishName")
        val englishName: String?,
        @SerialName("id")
        val id: Int?,
        @SerialName("imageUrl")
        val imageUrl: String?,
        @SerialName("koreanName")
        val koreanName: String?,
        @SerialName("price")
        val price: Int?
    )
}

fun DetailCategoryDTO.toDetailCategory(): List<DetailCategory> {
    val list = mutableListOf<DetailCategory>()

    this.products?.forEach {
        val best = requireNotNull(it.best)
        val engName = requireNotNull(it.englishName)
        val id = requireNotNull(it.id)
        val image = it.imageUrl.orEmpty()
        val korName = requireNotNull(it.koreanName)
        val price = requireNotNull(it.price)

        list.add(DetailCategory(best, engName, id, image, korName, price.toMoney()))
    }

    return list
}
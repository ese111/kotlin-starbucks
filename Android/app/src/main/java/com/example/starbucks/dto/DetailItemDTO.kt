package com.example.starbucks.dto


import com.example.starbucks.common.toMoney
import com.example.starbucks.data.vo.DetailItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailItemDTO(
    @SerialName("caffeine")
    val caffeine: Int?,
    @SerialName("calorie")
    val calorie: Int?,
    @SerialName("description")
    val description: String?,
    @SerialName("englishName")
    val englishName: String?,
    @SerialName("fat")
    val fat: Int?,
    @SerialName("id")
    val id: Int?,
    @SerialName("imageUrl")
    val imageUrl: String?,
    @SerialName("koreanName")
    val koreanName: String?,
    @SerialName("na")
    val na: Int?,
    @SerialName("price")
    val price: Int?,
    @SerialName("protein")
    val protein: Int?,
    @SerialName("sugars")
    val sugars: Int?
)

fun DetailItemDTO.toDetailItem(): DetailItem {
    val caffeine = requireNotNull(this.caffeine)
    val calorie = requireNotNull(this.calorie)
    val description = requireNotNull(this.description)
    val englishName = requireNotNull(this.englishName)
    val fat = requireNotNull(this.fat)
    val id = requireNotNull(this.id)
    val imageUrl = requireNotNull(this.imageUrl)
    val koreanName = requireNotNull(this.koreanName)
    val na = requireNotNull(this.na)
    val price = requireNotNull(this.price)
    val protein = requireNotNull(this.protein)
    val sugars = requireNotNull(this.sugars)

    return DetailItem(
        "${caffeine}mg",
        "${calorie}kcal",
        description,
        englishName,
        "${fat}g",
        id,
        imageUrl,
        koreanName,
        "${na}mg",
        price.toMoney(),
        "${protein}g",
        "${sugars}g"
    )
}
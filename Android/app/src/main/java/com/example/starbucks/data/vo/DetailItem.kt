package com.example.starbucks.data.vo

data class DetailItem(
    val caffeine: String = "",
    val calorie: String = "",
    val description: String = "",
    val englishName: String = "",
    val fat: String = "",
    val id: Int = 0,
    val imageUrl: String = "",
    val koreanName: String = "",
    val na: String = "",
    val price: String = "",
    val protein: String = "",
    val sugars: String = "",
    var isChecked: Boolean = false
)

fun DetailItem.toFavorite(): FavoriteMenu {
    val itemId = this.id
    val image = this.imageUrl
    val korName = this.koreanName
    val engName = this.englishName
    val price = this.price
    return FavoriteMenu(itemId, image, korName, engName, price)
}

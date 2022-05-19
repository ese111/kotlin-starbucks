package com.example.starbucks.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteMenu(
    val itemId: Int,
    val image: String,
    val korName: String,
    val engName: String,
    val price: String,
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

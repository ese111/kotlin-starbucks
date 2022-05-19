package com.example.starbucks.data.datasource

import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {

    fun getFavorite(): Flow<List<FavoriteMenu>>

    fun insertFavorite(item: FavoriteMenu)

    fun removeFavorite(item: FavoriteMenu)

    fun isChecked(id: Int): Boolean
}
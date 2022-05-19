package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getFavorite(): Flow<List<FavoriteMenu>>

    fun insertFavorite(item: FavoriteMenu)

    fun removeFavorite(item: FavoriteMenu)

    fun isChecked(id: Int): Boolean
}
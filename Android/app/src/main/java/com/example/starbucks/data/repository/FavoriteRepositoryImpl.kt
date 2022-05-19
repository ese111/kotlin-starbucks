package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.FavoriteDataSource
import com.example.starbucks.data.vo.DetailItem
import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FavoriteRepositoryImpl(private val dataSource: FavoriteDataSource) : FavoriteRepository {
    override fun getFavorite(): Flow<List<FavoriteMenu>> = dataSource.getFavorite().flowOn(Dispatchers.IO)

    override fun insertFavorite(item: FavoriteMenu) = dataSource.insertFavorite(item)

    override fun removeFavorite(item: FavoriteMenu) = dataSource.removeFavorite(item)

    override fun isChecked(id: Int): Boolean = dataSource.isChecked(id)
}
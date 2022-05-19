package com.example.starbucks.data.datasource

import com.example.starbucks.data.dao.FavoriteDAO
import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoriteDataSourceImpl(private val dao: FavoriteDAO) : FavoriteDataSource {
    override fun getFavorite(): Flow<List<FavoriteMenu>> = flow {
        emit(dao.getFavorite())
    }

    override fun insertFavorite(item: FavoriteMenu) {
        dao.insert(item)
    }

    override fun removeFavorite(item: FavoriteMenu) {
        dao.delete(item)
    }

    override fun isChecked(id: Int): Boolean =
        dao.isChecked(id)

}
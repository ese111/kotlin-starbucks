package com.example.starbucks.data.datasource

import com.example.starbucks.dto.DetailCategoryDTO
import com.example.starbucks.network.OrderApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailCategoryDataSourceImpl(private val api: OrderApi) : DetailCategoryDataSource {

    override suspend fun getDetailCategoryData(id: Int) = flow {
        emit(api.getDetailCategory(id))
    }
}
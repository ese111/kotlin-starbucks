package com.example.starbucks.data.datasource

import com.example.starbucks.network.DetailApi
import kotlinx.coroutines.flow.flow

class DetailDataSourceImpl(private val api: DetailApi) : DetailDataSource {
    override suspend fun getDetailData(id: Int) = flow {
        emit(api.getDetailData(id))
    }
}
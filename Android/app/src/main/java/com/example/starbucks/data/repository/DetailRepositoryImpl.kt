package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.DetailDataSource
import com.example.starbucks.data.vo.DetailItem
import com.example.starbucks.dto.toDetailItem
import kotlinx.coroutines.flow.single

class DetailRepositoryImpl(private val dataSource: DetailDataSource) : DetailRepository {

    override suspend fun getDetailData(id: Int): DetailItem {
        val result = dataSource.getDetailData(id).single()
        return result.toDetailItem()
    }

}
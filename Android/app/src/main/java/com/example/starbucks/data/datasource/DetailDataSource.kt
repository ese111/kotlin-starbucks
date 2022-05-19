package com.example.starbucks.data.datasource

import com.example.starbucks.dto.DetailItemDTO
import kotlinx.coroutines.flow.Flow

interface DetailDataSource {

    suspend fun getDetailData(id: Int): Flow<DetailItemDTO>
}
package com.example.starbucks.data.datasource

import com.example.starbucks.dto.DetailCategoryDTO
import kotlinx.coroutines.flow.Flow

interface DetailCategoryDataSource {

    suspend fun getDetailCategoryData(id: Int): Flow<DetailCategoryDTO>
}
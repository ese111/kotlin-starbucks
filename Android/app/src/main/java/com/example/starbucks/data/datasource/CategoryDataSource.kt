package com.example.starbucks.data.datasource

import com.example.starbucks.dto.CategoryMenuDTO
import com.example.starbucks.dto.DetailCategoryDTO
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    
    fun getCategory(type: String): Flow<CategoryMenuDTO>

    fun getDetailCategory(type: Int): Flow<DetailCategoryDTO>
}
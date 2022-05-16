package com.example.starbucks.data.datasource

import com.example.starbucks.data.vo.CategoryMenuData
import com.example.starbucks.dto.CategoryMenuDTO
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    
    fun getCategory(type: String): Flow<CategoryMenuDTO>
}
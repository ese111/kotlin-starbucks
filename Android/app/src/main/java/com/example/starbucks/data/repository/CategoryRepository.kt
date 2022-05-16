package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.CategoryMenuData

interface CategoryRepository {

    suspend fun getCategory(type: String): List<CategoryMenuData>

}
package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.CategoryMenuData
import com.example.starbucks.data.vo.DetailCategory

interface CategoryRepository {

    suspend fun getCategory(type: String): List<CategoryMenuData>

    suspend fun getDetailCategory(type: Int): List<DetailCategory>

}
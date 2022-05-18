package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.DetailCategory

interface DetailCategoryRepository {

    suspend fun getDetailCategoryData(id: Int): List<DetailCategory>
}
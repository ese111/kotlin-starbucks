package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.DetailCategoryDataSource
import com.example.starbucks.data.vo.DetailCategory
import com.example.starbucks.dto.toDetailCategory

class DetailCategoryRepositoryImpl(val dataSource: DetailCategoryDataSource) : DetailCategoryRepository {

    override suspend fun getDetailCategoryData(id: Int): List<DetailCategory> {
        var list = listOf<DetailCategory>()
        dataSource.getDetailCategoryData(id).collect{
            list = it.toDetailCategory()
        }
        return list
    }
}
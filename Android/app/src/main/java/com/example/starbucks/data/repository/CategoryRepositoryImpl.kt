package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.CategoryDataSource
import com.example.starbucks.data.vo.CategoryMenuData
import com.example.starbucks.dto.toMenuData

class CategoryRepositoryImpl(private val dataSource: CategoryDataSource) : CategoryRepository {

    override suspend fun getCategory(type: String): List<CategoryMenuData> {
        var list = listOf<CategoryMenuData>()

        dataSource.getCategory(type).collect{
            list = it.toMenuData()
        }

        return list
    }

}
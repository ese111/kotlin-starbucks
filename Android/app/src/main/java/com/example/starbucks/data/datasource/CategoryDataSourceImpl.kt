package com.example.starbucks.data.datasource

import com.example.starbucks.dto.toMenuData
import com.example.starbucks.network.HomeApi
import kotlinx.coroutines.flow.flow

class CategoryDataSourceImpl(private val api: HomeApi) : CategoryDataSource {

    override fun getCategory(type: String) = flow {
        emit(api.getCategory(type))
    }

}
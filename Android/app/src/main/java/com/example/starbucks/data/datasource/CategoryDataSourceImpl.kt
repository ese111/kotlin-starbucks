package com.example.starbucks.data.datasource

import com.example.starbucks.network.OrderApi
import kotlinx.coroutines.flow.flow

class CategoryDataSourceImpl(private val api: OrderApi) : CategoryDataSource {

    override fun getCategory(type: String) = flow {
        emit(api.getCategory(type))
    }

    override fun getDetailCategory(type: Int) = flow {
        emit(api.getDetailCategory(type))
    }

}
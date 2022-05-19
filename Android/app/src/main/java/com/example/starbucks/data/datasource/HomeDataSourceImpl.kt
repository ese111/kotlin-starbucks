package com.example.starbucks.data.datasource

import com.example.starbucks.network.HomeApi
import kotlinx.coroutines.flow.flow

class HomeDataSourceImpl(private val homeApi: HomeApi) : HomeDataSource {

    override fun getRecommendList() = flow {
        emit(homeApi.getRecommendMenu())
    }

    override fun getMainEvent() = flow {
        emit(homeApi.getMainEvent())
    }

    override fun ongoingEvent() = flow {
        emit(homeApi.getOngoingEvent())
    }

    override fun popularMenuList() = flow {
        emit(homeApi.getPopularMenu())
    }

}
package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getHomeData(): Flow<List<HomeData>>
}
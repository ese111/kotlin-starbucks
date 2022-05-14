package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.HomeData

interface HomeRepository {

    suspend fun getHomeData(): List<HomeData>
}
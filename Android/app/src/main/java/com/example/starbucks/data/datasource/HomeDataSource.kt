package com.example.starbucks.data.datasource

import com.example.starbucks.dto.RecommendMenuDTO
import com.example.starbucks.dto.MainEventDTO
import com.example.starbucks.dto.OngoingEventDTO
import com.example.starbucks.dto.PopularMenuDTO
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {

    fun getRecommendList(): Flow<List<RecommendMenuDTO>>

    fun getMainEvent(): Flow<MainEventDTO>

    fun ongoingEvent(): Flow<List<OngoingEventDTO>>

    fun popularMenuList(): Flow<List<PopularMenuDTO>>

}
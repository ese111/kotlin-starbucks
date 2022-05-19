package com.example.starbucks.data.repository

import android.widget.TextView
import com.example.starbucks.data.datasource.HomeDataSource
import com.example.starbucks.data.vo.HomeData
import com.example.starbucks.dto.toMainEvent
import com.example.starbucks.dto.toOngoingEvent
import com.example.starbucks.dto.toPopularMenu
import com.example.starbucks.dto.toRecommendMenu
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.*

class HomeRepositoryImpl(private val dataSource: HomeDataSource) : HomeRepository {

    override fun getHomeData(): Flow<List<HomeData>> = flow {
        val homeData = mutableListOf<HomeData>()
        homeData.add(HomeData.HomeLabel("얼음JK"))
        dataSource.getRecommendList().collect{ homeData.add(it.toRecommendMenu())}
        dataSource.getMainEvent().collect{ homeData.add(it.toMainEvent()) }
        homeData.add(HomeData.EventAllViewBtnLabel())
        dataSource.ongoingEvent().collect{ homeData.add(it.toOngoingEvent()) }
        homeData.add(HomeData.PoplarMenuLabel(time = getTime()))
        dataSource.popularMenuList().collect{ homeData.add(it.toPopularMenu()) }
        emit(homeData)

    }

    private fun getTime(): String {
        val currentTime = System.currentTimeMillis()

        val today = Date(currentTime)
        val dateFormat = SimpleDateFormat("hh E", Locale.getDefault())
        val date = dateFormat.format(today)
        val now = date.split(" ")

        return when(now[1]) {
            "토","일" -> "주말 ${now[0]}시 기준"
            else -> "주중 ${now[0]}시 기준"
        }
    }
}
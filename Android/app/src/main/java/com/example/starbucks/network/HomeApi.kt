package com.example.starbucks.network

import com.example.starbucks.dto.*
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApi {

    @GET("/products/recommend")
    suspend fun getRecommendMenu(): List<RecommendMenuDTO>

    @GET("/events/main")
    suspend fun getMainEvent(): MainEventDTO

    @GET("/events/ongoing")
    suspend fun getOngoingEvent(): List<OngoingEventDTO>

    @GET("/products?sort-by=price&order-by=desc")
    suspend fun getPopularMenu(): List<PopularMenuDTO>

    @GET("/categories")
    suspend fun getCategory(
        @Query("category-type") type: String
    ): CategoryMenuDTO

}
package com.example.starbucks.network

import com.example.starbucks.dto.StartEventDTO
import retrofit2.http.GET

interface EventApi {

    @GET("events/popup")
    suspend fun getEventInfo(): StartEventDTO

}
package com.example.starbucks.network

import com.example.starbucks.dto.StartEventDTO
import retrofit2.http.GET

interface EventApi {

    @GET("jk/boostcamp/starbuckst-loading.json")
    suspend fun getEventInfo(): StartEventDTO

}
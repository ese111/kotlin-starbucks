package com.example.starbucks.network

import com.example.starbucks.dto.WhatsNewDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface WhatsNewApi {
    @GET("/events?sort-by=startDateTime&order-by=desc")
    suspend fun getWhatsNewList(): List<WhatsNewDTO>
}
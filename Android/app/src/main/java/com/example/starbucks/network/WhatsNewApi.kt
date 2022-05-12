package com.example.starbucks.network

import com.example.starbucks.dto.WhatsNewDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface WhatsNewApi {
    @GET("whats_new/newsListAjax.do")
    suspend fun getWhatsNewList(): WhatsNewDTO
}
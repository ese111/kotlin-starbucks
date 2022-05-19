package com.example.starbucks.network

import com.example.starbucks.dto.DetailItemDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {

    @GET("/products/{id}")
    suspend fun getDetailData(
        @Path("id") id: Int
    ): DetailItemDTO
}
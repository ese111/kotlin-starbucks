package com.example.starbucks.network

import com.example.starbucks.dto.CategoryMenuDTO
import com.example.starbucks.dto.DetailCategoryDTO
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Query

interface OrderApi {

    @GET("/categories")
    suspend fun getCategory(
        @Query("category-type") type: String
    ): CategoryMenuDTO

    @GET("/categories/{id}")
    suspend fun getDetailCategory(
        @Part("id") id: Int
    ): DetailCategoryDTO

}
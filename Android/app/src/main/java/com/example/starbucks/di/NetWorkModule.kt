@file:OptIn(ExperimentalSerializationApi::class)

package com.example.starbucks.di

import com.example.starbucks.data.datasource.WhatsNewDataSourceImpl
import com.example.starbucks.network.WhatsNewApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.starbucks.co.kr/"

private const val HOME_URL = "https://api.codesquad.kr/starbuckst/"

private val json = Json {
    isLenient = true // Jso\n 큰따옴표 느슨하게 체크.
    ignoreUnknownKeys = true // Field 값이 없는 경우 무시
    coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
}

val whatsNewApiNetWorkModule = module {

    val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    single {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val contentType = "application/json".toMediaType()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
//            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WhatsNewApi::class.java)
    }

    factory { WhatsNewDataSourceImpl(get()) }
}

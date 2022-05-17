
package com.example.starbucks.di

import com.example.starbucks.network.*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

private const val BASE_URL = "https://www.starbucks.co.kr/"

private const val HOME_URL = "http://louie-03.com/"

private const val TEMP_URL = "https://public.codesquad.kr/"

private val json = Json {
    isLenient = true // Jso\n 큰따옴표 느슨하게 체크.
    ignoreUnknownKeys = true // Field 값이 없는 경우 무시
    coerceInputValues = true // "null" 이 들어간경우 default Argument 값으로 대체
}

private val logger = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

private val contentType = "application/json".toMediaType()

val netWorkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(HOME_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(WhatsNewApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(HOME_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(HomeApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(DetailApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(TEMP_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(EventApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(HOME_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(OrderApi::class.java)
    }

}

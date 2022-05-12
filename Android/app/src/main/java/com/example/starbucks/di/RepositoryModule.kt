package com.example.starbucks.di

import com.example.starbucks.data.datasource.WhatsNewDataSource
import com.example.starbucks.data.datasource.WhatsNewDataSourceImpl
import com.example.starbucks.data.repository.WhatsNewRepositoryImpl
import org.koin.dsl.module

val whatsNewRepositoryModule = module {

    single<WhatsNewDataSource> { WhatsNewDataSourceImpl(get()) }

    factory { WhatsNewRepositoryImpl(get()) }
}
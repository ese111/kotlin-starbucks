package com.example.starbucks.di

import com.example.starbucks.data.datasource.*
import org.koin.dsl.module

val dataSourceModule = module {

    single<WhatsNewDataSource> { WhatsNewDataSourceImpl(get()) }
    single<HomeDataSource> { HomeDataSourceImpl(get()) }
    single<EventDialogDataSource> { EventDialogDataSourceImpl(get()) }
    single<CategoryDataSource> { CategoryDataSourceImpl(get()) }
    single<DetailCategoryDataSource> { DetailCategoryDataSourceImpl(get()) }
}
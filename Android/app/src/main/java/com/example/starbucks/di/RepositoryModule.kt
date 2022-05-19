package com.example.starbucks.di

import com.example.starbucks.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {

    single<WhatsNewRepository> { WhatsNewRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<EventDialogRepository> { EventDialogRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<DetailCategoryRepository> { DetailCategoryRepositoryImpl(get()) }
    single<DetailRepository> { DetailRepositoryImpl(get()) }
}

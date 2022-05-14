package com.example.starbucks.di

import com.example.starbucks.data.repository.*
import org.koin.dsl.module

val repositoryModule = module {

    single<WhatsNewRepository> { WhatsNewRepositoryImpl(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<EventDialogRepository> { EventDialogRepositoryImpl(get()) }
}

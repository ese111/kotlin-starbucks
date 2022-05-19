package com.example.starbucks.di

import androidx.room.Room
import com.example.starbucks.data.database.FavoriteDB
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(get(),
        FavoriteDB::class.java,
            "database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<FavoriteDB>().favoriteDAO()
    }
}
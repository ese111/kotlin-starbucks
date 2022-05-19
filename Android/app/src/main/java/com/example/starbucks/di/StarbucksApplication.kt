package com.example.starbucks.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class StarbucksApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@StarbucksApplication)
            modules(
                netWorkModule,
                dataSourceModule,
                repositoryModule,
                viewModelModule,
                databaseModule
            )
        }
    }
}
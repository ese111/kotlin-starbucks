package com.example.starbucks.di

import com.example.starbucks.data.repository.WhatsNewRepository
import com.example.starbucks.data.repository.WhatsNewRepositoryImpl
import com.example.starbucks.ui.whatsnew.WhatsNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val whatsNewViewModelModule = module {

    single<WhatsNewRepository> { WhatsNewRepositoryImpl(get()) }

    viewModel { WhatsNewViewModel(get()) }
}
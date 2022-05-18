package com.example.starbucks.di

import com.example.starbucks.ui.home.HomeViewModel
import com.example.starbucks.ui.order.OrderViewModel
import com.example.starbucks.ui.order.detail.DetailCategoryViewModel
import com.example.starbucks.ui.startevent.EventDialogViewModel
import com.example.starbucks.ui.whatsnew.WhatsNewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { WhatsNewViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { EventDialogViewModel(get()) }
    viewModel { OrderViewModel(get()) }
    viewModel { DetailCategoryViewModel(get()) }
}
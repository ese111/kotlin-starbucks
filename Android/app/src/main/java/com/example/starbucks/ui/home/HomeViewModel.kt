package com.example.starbucks.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.HomeRepository
import com.example.starbucks.data.vo.HomeData
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository): ViewModel() {

    private val _homeData = MutableLiveData<List<HomeData>>()
    val homeData = _homeData

    init {
        getHomeDataList()
    }

    fun getHomeDataList() {
        viewModelScope.launch {
            _homeData.value = homeRepository.getHomeData()
        }
    }
}
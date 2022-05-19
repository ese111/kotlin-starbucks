package com.example.starbucks.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.HomeRepository
import com.example.starbucks.data.vo.HomeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _homeData = MutableStateFlow<List<HomeData>>(emptyList())
    val homeData = _homeData

    init {
        getHomeDataList()
    }

    private fun getHomeDataList() {
        viewModelScope.launch {
            homeRepository.getHomeData().collect {
                _homeData.value = it
            }
        }
    }
}
package com.example.starbucks.ui.order.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.CategoryRepository
import com.example.starbucks.data.vo.DetailCategory
import kotlinx.coroutines.launch

class DetailCategoryViewModel(private val repository: CategoryRepository): ViewModel() {

    private val _detailCategoryData = MutableLiveData<List<DetailCategory>>()
    val detailCategoryData: LiveData<List<DetailCategory>> = _detailCategoryData


    fun getDetailCategory(type: Int) {
        viewModelScope.launch {
            _detailCategoryData.value = repository.getDetailCategory(type)
        }
    }
}
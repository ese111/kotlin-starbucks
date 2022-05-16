package com.example.starbucks.ui.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.CategoryRepository
import com.example.starbucks.data.vo.CategoryMenuData
import kotlinx.coroutines.launch

class OrderViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _categoryData = MutableLiveData<List<CategoryMenuData>>()
    val categoryData: LiveData<List<CategoryMenuData>> = _categoryData

    fun getCategoryData(type: String) {
        viewModelScope.launch {
            _categoryData.value = repository.getCategory(type)
        }
    }

}
package com.example.starbucks.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.dao.FavoriteDAO
import com.example.starbucks.data.repository.DetailRepository
import com.example.starbucks.data.vo.DetailItem
import com.example.starbucks.data.vo.FavoriteMenu
import com.example.starbucks.data.vo.toFavorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val dao: FavoriteDAO, private val repository: DetailRepository): ViewModel() {

    private val _detailData = MutableLiveData<DetailItem>()
    val detailData: LiveData<DetailItem> = _detailData

    fun getDetailData(id: Int) {
        viewModelScope.launch {
            val data = repository.getDetailData(id)
            data.isChecked = isChecked(id)
            _detailData.value = data
        }
    }

    private suspend fun isChecked(id: Int): Boolean {
        return withContext(Dispatchers.IO) {
            dao.isChecked(id)
        }
    }

    fun addFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            detailData.value?.let {
                dao.insert(it.toFavorite())
            }
        }
    }
}
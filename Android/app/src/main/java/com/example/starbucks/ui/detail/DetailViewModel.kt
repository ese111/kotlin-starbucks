package com.example.starbucks.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.DetailRepository
import com.example.starbucks.data.repository.FavoriteRepository
import com.example.starbucks.data.vo.DetailItem
import com.example.starbucks.data.vo.toFavorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val favoriteRepository: FavoriteRepository,
    private val detailRepository: DetailRepository
) : ViewModel() {

    private val _detailData = MutableStateFlow(DetailItem())
    val detailData: StateFlow<DetailItem> = _detailData

    fun getDetailData(id: Int) {
        viewModelScope.launch {
            val data = detailRepository.getDetailData(id)
            data.isChecked = isChecked(id)

            _detailData.value = data
        }
    }

    private suspend fun isChecked(id: Int) = withContext(Dispatchers.IO) {
        favoriteRepository.isChecked(id)
    }


    fun addFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            detailData.value.let {
                favoriteRepository.insertFavorite(it.toFavorite())
            }
        }
    }

    fun removeFavorite() {
        viewModelScope.launch(Dispatchers.IO) {
            detailData.value.let {
                favoriteRepository.removeFavorite(it.toFavorite())
            }
        }
    }
}
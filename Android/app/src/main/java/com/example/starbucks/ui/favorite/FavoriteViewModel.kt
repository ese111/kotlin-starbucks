package com.example.starbucks.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.dao.FavoriteDAO
import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(private val dao: FavoriteDAO): ViewModel() {

    private val _favoriteMenu = MutableLiveData<List<FavoriteMenu>>()
    val favoriteMenu: LiveData<List<FavoriteMenu>> = _favoriteMenu

    init {
        getFavoriteData()
    }

    private fun getFavoriteData() {
        viewModelScope.launch {
            val data = withContext(Dispatchers.IO) {
                dao.getFavorite()
            }
            _favoriteMenu.value = data
        }
    }

    fun removeFavoriteData(item: FavoriteMenu) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(item)
        }
    }
}
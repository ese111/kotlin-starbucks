package com.example.starbucks.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.dao.FavoriteDAO
import com.example.starbucks.data.vo.FavoriteMenu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(private val dao: FavoriteDAO): ViewModel() {

    private val _favoriteMenu = MutableStateFlow<List<FavoriteMenu>>(emptyList())
    val favoriteMenu: StateFlow<List<FavoriteMenu>> = _favoriteMenu

    fun getFavoriteData() {
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
            getFavoriteData()
        }
    }

    fun addFavoriteData(item: FavoriteMenu) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(item)
        }
    }
}
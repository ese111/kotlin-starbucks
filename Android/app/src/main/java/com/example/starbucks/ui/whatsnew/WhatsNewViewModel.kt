package com.example.starbucks.ui.whatsnew

import android.util.Log
import androidx.lifecycle.*
import com.example.starbucks.common.SingleLiveEvent
import com.example.starbucks.data.WhatsNewItem
import com.example.starbucks.data.repository.WhatsNewRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WhatsNewViewModel(private val whatsNewRepository: WhatsNewRepository) : ViewModel() {

    private val _whatsNewList = MutableLiveData<List<WhatsNewItem>>()
    val whatsNewList: LiveData<List<WhatsNewItem>> = _whatsNewList

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> get() = _error

    init {
        getWhatsNewList()
    }

    private fun getWhatsNewList() {
        viewModelScope.launch {
            whatsNewRepository.getWhatsNewList().collect{
                _whatsNewList.value = it
            }
        }
    }
}
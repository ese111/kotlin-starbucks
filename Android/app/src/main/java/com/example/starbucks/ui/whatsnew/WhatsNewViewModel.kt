package com.example.starbucks.ui.whatsnew

import androidx.lifecycle.*
import com.example.starbucks.common.SingleLiveEvent
import com.example.starbucks.data.vo.WhatsNewItem
import com.example.starbucks.data.repository.WhatsNewRepository
import kotlinx.coroutines.launch

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
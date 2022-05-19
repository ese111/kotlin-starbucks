package com.example.starbucks.ui.startevent

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.EventDialogRepository
import com.example.starbucks.data.vo.StartEvent
import kotlinx.coroutines.launch

class EventDialogViewModel(private val repository: EventDialogRepository): ViewModel() {

    private val _info = MutableLiveData<StartEvent>()
    val info = _info

    init {
        getEventInfo()
    }

    private fun getEventInfo() {
        viewModelScope.launch {
            _info.value = repository.getEventInfo()
        }
    }
}
package com.example.starbucks.ui.startevent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starbucks.data.repository.EventDialogRepository
import com.example.starbucks.data.vo.StartEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class EventDialogViewModel(private val repository: EventDialogRepository): ViewModel() {

    private val _info = MutableStateFlow(StartEvent())
    val info = _info

    init {
        viewModelScope.launch {
             repository.getEventInfo().collect{
                _info.value = it
            }
        }
    }

}
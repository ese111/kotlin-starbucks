package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.EventDialogDataSource
import com.example.starbucks.data.vo.StartEvent
import com.example.starbucks.dto.toStartEvent
import kotlinx.coroutines.flow.Flow

class EventDialogRepositoryImpl(private val dataSource: EventDialogDataSource) : EventDialogRepository {

    override suspend fun getEventInfo(): StartEvent {
        var info = StartEvent("","","","","")

        dataSource.getStartEventInfo().collect { eventDTO ->
            info = eventDTO.toStartEvent()
        }

        return info
    }

}
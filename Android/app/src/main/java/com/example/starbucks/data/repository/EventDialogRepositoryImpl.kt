package com.example.starbucks.data.repository

import android.util.Log
import com.example.starbucks.data.datasource.EventDialogDataSource
import com.example.starbucks.data.vo.StartEvent
import com.example.starbucks.dto.toStartEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class EventDialogRepositoryImpl(private val dataSource: EventDialogDataSource) :
    EventDialogRepository {

    override fun getEventInfo(): Flow<StartEvent> =
        dataSource.getStartEventInfo().map { dto ->
            dto.toStartEvent()
        }.catch { e ->
            Log.e("EventDialogRepository", "${e.message}")
        }.flowOn(Dispatchers.IO)

}
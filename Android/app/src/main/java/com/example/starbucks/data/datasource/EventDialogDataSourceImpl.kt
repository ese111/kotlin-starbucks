package com.example.starbucks.data.datasource

import com.example.starbucks.network.EventApi
import kotlinx.coroutines.flow.flow

class EventDialogDataSourceImpl(private val api: EventApi) : EventDialogDataSource {

    override fun getStartEventInfo() = flow {
        emit(api.getEventInfo())
    }

}
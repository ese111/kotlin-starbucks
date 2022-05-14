package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.StartEvent
import kotlinx.coroutines.flow.Flow

interface EventDialogRepository {

    suspend fun getEventInfo(): StartEvent

}
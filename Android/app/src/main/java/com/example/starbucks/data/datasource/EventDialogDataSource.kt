package com.example.starbucks.data.datasource

import com.example.starbucks.dto.StartEventDTO
import kotlinx.coroutines.flow.Flow

interface EventDialogDataSource {

    fun getStartEventInfo(): Flow<StartEventDTO>
}
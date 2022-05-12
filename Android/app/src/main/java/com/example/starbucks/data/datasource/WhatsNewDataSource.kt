package com.example.starbucks.data.datasource

import com.example.starbucks.data.WhatsNewItem
import com.example.starbucks.dto.WhatsNewDTO
import kotlinx.coroutines.flow.Flow

interface WhatsNewDataSource {

    fun getWhatsNew(): Flow<List<WhatsNewItem>>
}
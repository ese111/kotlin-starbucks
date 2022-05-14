package com.example.starbucks.data.datasource

import com.example.starbucks.data.vo.WhatsNewItem
import kotlinx.coroutines.flow.Flow

interface WhatsNewDataSource {

    fun getWhatsNew(): Flow<List<WhatsNewItem>>
}
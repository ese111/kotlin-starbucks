package com.example.starbucks.data.repository

import com.example.starbucks.data.WhatsNewItem
import com.example.starbucks.dto.WhatsNewDTO
import kotlinx.coroutines.flow.Flow

interface WhatsNewRepository {

    fun getWhatsNewList(): Flow<List<WhatsNewItem>>
}
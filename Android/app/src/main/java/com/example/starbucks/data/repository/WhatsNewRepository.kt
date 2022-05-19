package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.WhatsNewItem
import kotlinx.coroutines.flow.Flow

interface WhatsNewRepository {

    fun getWhatsNewList(): Flow<List<WhatsNewItem>>
}
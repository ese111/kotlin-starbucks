package com.example.starbucks.data.datasource

import com.example.starbucks.data.vo.WhatsNewItem
import com.example.starbucks.dto.toWhatsNewList
import com.example.starbucks.network.WhatsNewApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WhatsNewDataSourceImpl(private val whatsNewApi: WhatsNewApi) : WhatsNewDataSource {

    override fun getWhatsNew(): Flow<List<WhatsNewItem>> = flow {
        emit(whatsNewApi.getWhatsNewList().toWhatsNewList())
    }

}
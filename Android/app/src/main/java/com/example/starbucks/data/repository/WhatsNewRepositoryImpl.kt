package com.example.starbucks.data.repository

import com.example.starbucks.data.datasource.WhatsNewDataSource

class WhatsNewRepositoryImpl(private val whatsNewDataSource: WhatsNewDataSource) : WhatsNewRepository {

    override fun getWhatsNewList() = whatsNewDataSource.getWhatsNew()

}
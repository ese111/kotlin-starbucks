package com.example.starbucks.data.repository

import com.example.starbucks.data.vo.DetailItem

interface DetailRepository {

    suspend fun getDetailData(id: Int): DetailItem
}
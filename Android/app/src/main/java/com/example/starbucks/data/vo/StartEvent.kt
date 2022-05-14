package com.example.starbucks.data.vo

import kotlinx.serialization.SerialName


data class StartEvent(
    val title: String,
    val range: String,
    val target: String,
    val description: String,
    val eventProducts: String
)

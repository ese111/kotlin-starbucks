package com.example.starbucks.common

import android.os.Build
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun String.getEventRange(endDate: String) = "$this ~ $endDate"

fun String.toDate(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        val outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일", Locale.ENGLISH);
        val date = LocalDate.parse(this, inputFormatter);
        outputFormatter.format(date)
    } else {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault())
        val date = inputFormat.parse("this")
        outputFormat.format(date)
    }
}

fun Int.toMoney(): String {
    val decimalFormat = DecimalFormat("#,###원")
    return decimalFormat.format(this.toLong())
}

package com.example.starbucks.common

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("labelColor")
fun setLabelColor(textView: TextView, user: String) {
    val text = "${user}님을 위한 추천 메뉴"
    val spannableString = SpannableString(text)

    val start = text.indexOf(user)
    val end = start + user.length

    spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#FF9999")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannableString.setSpan(RelativeSizeSpan(1.3f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

    textView.text = spannableString
}


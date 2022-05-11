package com.example.starbucks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starbucks.databinding.ActivityWhatsNewBinding

class WhatsNewActivity: AppCompatActivity() {

    private val binding: ActivityWhatsNewBinding by lazy {
        ActivityWhatsNewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}
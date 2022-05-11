package com.example.starbucks.ui.whatsnew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.databinding.ActivityWhatsNewBinding

class WhatsNewActivity: AppCompatActivity() {

    private val binding: ActivityWhatsNewBinding by lazy {
        ActivityWhatsNewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val whatsNewAdapter = WhatsNewAdapter()

        binding.rvWhatsNewList.apply {
            adapter = whatsNewAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }
}
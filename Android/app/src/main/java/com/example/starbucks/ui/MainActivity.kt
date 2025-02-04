package com.example.starbucks.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.starbucks.R
import com.example.starbucks.databinding.ActivityMainBinding
import com.example.starbucks.ui.startevent.EventFragment
import com.example.starbucks.ui.whatsnew.WhatsNewActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val dialog = EventFragment()

        if(checkClosedEventPopup()){
            dialog.show(supportFragmentManager, "EventDialog")
        }

        val nav = supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        val navControl = nav.findNavController()
        binding.bottomNavigation.setupWithNavController(navControl)
    }


    private fun checkClosedEventPopup(): Boolean {
        val currentTime = System.currentTimeMillis()

        val today = Date(currentTime)
        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
        val date = dateFormat.format(today)

        val sharedPreferences = binding.root.context.getSharedPreferences("com.example.starbucks.ui",
            Context.MODE_PRIVATE)
        val closeDay = sharedPreferences.getString("Day","0") ?: date

        return (Integer.parseInt(date) - Integer.parseInt(closeDay)) != 0
    }
}
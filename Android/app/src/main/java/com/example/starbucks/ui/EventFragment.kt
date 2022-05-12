package com.example.starbucks.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.starbucks.databinding.FragmentEventDialogBinding
import java.text.SimpleDateFormat
import java.util.*

class EventFragment: DialogFragment() {
    private val binding: FragmentEventDialogBinding by lazy {
        FragmentEventDialogBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentTime = System.currentTimeMillis()

        val today = Date(currentTime)
        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
        val date = dateFormat.format(today)

        val sharedPreferences = binding.root.context.getSharedPreferences("com.example.starbucks.ui",Context.MODE_PRIVATE)

        binding.btnEventClose.setOnClickListener {
            dismiss()
        }

        binding.btnTodayClose.setOnClickListener {
            val sharedPreferencesEditor = sharedPreferences.edit()
            sharedPreferencesEditor.putString("Day", date)
            sharedPreferencesEditor.apply()
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        // full Screen code
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
    }

}
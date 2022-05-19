package com.example.starbucks.ui.startevent

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.starbucks.databinding.FragmentEventDialogBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class EventFragment: DialogFragment() {
    private val binding: FragmentEventDialogBinding by lazy {
        FragmentEventDialogBinding.inflate(layoutInflater)
    }

    private val viewModel: EventDialogViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.info.collect {
                    binding.item = it
                }
            }
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
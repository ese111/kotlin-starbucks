package com.example.starbucks.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.R
import com.example.starbucks.databinding.FragmentOrderBinding


class OderFragment : Fragment() {

    private val binding: FragmentOrderBinding by lazy {
        FragmentOrderBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }



}
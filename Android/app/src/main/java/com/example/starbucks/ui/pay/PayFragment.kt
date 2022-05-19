package com.example.starbucks.ui.pay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.R
import com.example.starbucks.databinding.FragmentPayBinding

class PayFragment : Fragment() {

    private val binding: FragmentPayBinding by lazy {
        FragmentPayBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.livCup.setAnimation("13618-cup.json")
        binding.livStar.setAnimation("88759-exploding-star.json")
        binding.livCup.playAnimation()
        binding.livStar.playAnimation()
        binding.livCup.repeatCount = 2
        binding.livStar.repeatCount = 2
    }
}
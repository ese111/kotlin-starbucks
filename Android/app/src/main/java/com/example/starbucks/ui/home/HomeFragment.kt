package com.example.starbucks.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starbucks.databinding.FragmentHomeBinding
import com.example.starbucks.ui.whatsnew.WhatsNewActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel:HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomeAdapter()
        binding.rvHome.adapter = adapter

        viewModel.homeData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        setClickWhatsNew()
    }

    private fun setClickWhatsNew() {
        binding.topAppBar.setOnClickListener {
            val intent = Intent(activity, WhatsNewActivity::class.java)
            startActivity(intent)
        }
    }

}
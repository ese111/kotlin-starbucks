package com.example.starbucks.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.R
import com.example.starbucks.data.vo.FavoriteMenu
import com.example.starbucks.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private val binding: FragmentFavoriteBinding by lazy {
        FragmentFavoriteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = FavoriteAdapter()
        binding.rvListInFavorite.adapter = adapter
        val tmpList = listOf(FavoriteMenu("아메리카노"))
        adapter.submitList(tmpList)
    }
}
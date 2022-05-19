package com.example.starbucks.ui.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.R
import com.example.starbucks.data.vo.FavoriteMenu
import com.example.starbucks.databinding.FragmentFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val binding: FragmentFavoriteBinding by lazy {
        FragmentFavoriteBinding.inflate(layoutInflater)
    }

    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFavoriteData()

        val adapter = FavoriteAdapter{ data, isChecked ->
            when(isChecked) {
                true -> viewModel.addFavoriteData(data)
                false -> viewModel.removeFavoriteData(data)
            }
        }

        binding.rvListInFavorite.adapter = adapter
        viewModel.favoriteMenu.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

}
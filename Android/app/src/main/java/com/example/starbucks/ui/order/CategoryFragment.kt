package com.example.starbucks.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starbucks.databinding.FragmentCategoryBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CategoryFragment: Fragment() {

    private val binding: FragmentCategoryBinding by lazy {
        FragmentCategoryBinding.inflate(layoutInflater)
    }

    private val viewModel: OrderViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainCategoryAdapter()

        binding.rvItemMenu.adapter = adapter


        viewModel.categoryData.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }
    }
}
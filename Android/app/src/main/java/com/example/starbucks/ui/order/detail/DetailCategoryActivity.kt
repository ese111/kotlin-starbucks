package com.example.starbucks.ui.order.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starbucks.databinding.ActivityDetailCategoryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailCategoryActivity : AppCompatActivity() {

    private val binding: ActivityDetailCategoryBinding by lazy {
        ActivityDetailCategoryBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailCategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val type = intent.getIntExtra("type", 0)

        viewModel.getDetailCategory(type)

        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailCategoryAdapter()

        binding.rvListInDetailCategory.adapter = adapter

        viewModel.detailCategoryData.observe(this) {
            adapter.submitList(it)
        }
    }

}
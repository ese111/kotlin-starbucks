package com.example.starbucks.ui.order.detail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.starbucks.databinding.ActivityDetailCategoryBinding
import com.example.starbucks.ui.detail.DetailActivity
import com.example.starbucks.ui.order.CategoryClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailCategoryActivity : AppCompatActivity(), CategoryClickListener {

    private val binding: ActivityDetailCategoryBinding by lazy {
        ActivityDetailCategoryBinding.inflate(layoutInflater)
    }

    private val viewModel: DetailCategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent = intent
        val type = intent.getIntExtra("id", 0)

        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailCategoryAdapter(this)

        binding.rvListInDetailCategory.adapter = adapter

        viewModel.detailCategoryData.observe(this) {
            adapter.submitList(it)
        }

        viewModel.getDetailCategory(type)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return true
    }

    override fun moveDetailPage(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}
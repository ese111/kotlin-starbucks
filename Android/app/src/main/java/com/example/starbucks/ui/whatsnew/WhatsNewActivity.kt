package com.example.starbucks.ui.whatsnew

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starbucks.databinding.ActivityWhatsNewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WhatsNewActivity: AppCompatActivity() {

    private val binding: ActivityWhatsNewBinding by lazy {
        ActivityWhatsNewBinding.inflate(layoutInflater)
    }

    private val viewModel: WhatsNewViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val whatsNewAdapter = WhatsNewAdapter()

        binding.rvWhatsNewList.apply {
            adapter = whatsNewAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.whatsNewList.observe(this){
            whatsNewAdapter.submitList(it)
        }

        viewModel.error.observe(this) {
            Toast.makeText(this, viewModel.error.value, Toast.LENGTH_SHORT).show()
        }
        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> { //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
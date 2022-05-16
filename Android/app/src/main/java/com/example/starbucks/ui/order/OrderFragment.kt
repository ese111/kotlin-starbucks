package com.example.starbucks.ui.order

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starbucks.R
import com.example.starbucks.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayout
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private val type = listOf("DRINK", "FOOD", "GOODS")

class OderFragment : Fragment() {

    private val binding: FragmentOrderBinding by lazy {
        FragmentOrderBinding.inflate(layoutInflater)
    }

    private val viewModel: OrderViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCategoryData(type[0])
        childFragmentManager.beginTransaction()
            .replace(R.id.fcv_order, CategoryFragment()).commit()

        Log.e("TAG", "order ${viewModel.hashCode()}")
        setTabMenu()
    }

    private fun setTabMenu() {
        binding.tlOrderTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewModel.getCategoryData(type[tab.position])
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fcv_order, CategoryFragment()).commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }


}
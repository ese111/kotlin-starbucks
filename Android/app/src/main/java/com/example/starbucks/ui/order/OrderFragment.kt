package com.example.starbucks.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.starbucks.R
import com.example.starbucks.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayout

private val itemViewList: List<Fragment> by lazy {
    val list = mutableListOf<Fragment>()
    list.add(DrinkFragment())
    list.add(FoodFragment())
    list.add(ItemFragment())

    list
}

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.beginTransaction()
            .replace(R.id.fcv_order, itemViewList[0]).commit()

        binding.tlOrderTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.fcv_order, itemViewList[it.position]).commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }


}
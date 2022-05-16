package com.example.starbucks

import androidx.lifecycle.Observer
import com.example.starbucks.data.repository.CategoryRepository
import com.example.starbucks.data.vo.CategoryMenuData
import com.example.starbucks.ui.order.OrderViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.`when`
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class OrderViewModelTest {

    @Mock
    private lateinit var repo: CategoryRepository

    @Mock
    private lateinit var observer: Observer<List<CategoryMenuData>>

//    @Test
//    suspend fun getCategory_테스트() {
//        MockitoAnnotations.openMocks(this)
//        val viewModelTest = OrderViewModel(repo)
//
//        `given`(repo.getCategory("DRINK")).willReturn(
//            listOf(
//                CategoryMenuData(
//                    "Cold brew",
//                    1,
//                    "imageUrl",
//                    "콜드브루",
//                ),
//                CategoryMenuData(
//                    "Espresso",
//                    2,
//                    "image2",
//                    "에스프레소"
//                ),
//                CategoryMenuData(
//                    "Frappuccino",
//                    3,
//                    "image3",
//                    "프라푸치노"
//                )
//            )
//        )
//
//        try {
//            viewModelTest.drinkMenu.observeForever(observer)
//            viewModelTest.getDrinkMenu("DRINK")
//
//            assertThat(viewModelTest.drinkMenu.value?.get(0)?.englishName, notNull())
//
//        } finally {
//            viewModelTest.drinkMenu.removeObserver(observer)
//        }
//
//    }
}
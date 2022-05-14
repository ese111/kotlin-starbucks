package com.example.starbucks

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.starbucks.ui.MainActivity
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TabTest {

    @get:Rule
    var activityScenario: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun 음료탭_클릭시_음료화면_이동_테스트() {
        onView(withId(R.id.btn_event_close)).perform(click())
        onView(withId(R.id.order)).perform(click())
        onView(withId(R.id.tl_order_tab)).perform(selectTabAtPosition(0))
        onView(withId(R.id.drinkFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun 음식탭_클릭시_음식화면_이동_테스트() {
        onView(withId(R.id.btn_event_close)).perform(click())
        onView(withId(R.id.order)).perform(click())
        onView(withId(R.id.tl_order_tab)).perform(click())
        onView(withId(R.id.foodFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun 상품탭_클릭시_상품화면_이동_테스트() {
        onView(withId(R.id.btn_event_close)).perform(click())
        onView(withId(R.id.order)).perform(click())
        onView(withId(R.id.tl_order_tab)).perform(selectTabAtPosition(2))
        onView(withId(R.id.itemFragment)).check(matches(isDisplayed()))
    }
    
    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() = allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }

}
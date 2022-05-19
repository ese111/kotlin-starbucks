package com.example.starbucks

import android.content.Context
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.starbucks.ui.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class EventPageTest {

    @get:Rule
    var activityScenario: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp_firstStartApp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val sharedPreferences = context.getSharedPreferences("com.example.starbucks", Context.MODE_PRIVATE)
        sharedPreferences.edit().run {
            clear()
            commit()
        }
    }

    @Test
    fun 초기_이벤트_생성_확인_테스트() {
        activityScenario.scenario.recreate()
        onView(withId(R.id.df_event)).check(matches(isDisplayed()))
    }

//    @Before
//    fun setUp_do_not_see() {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//
//        val currentTime = System.currentTimeMillis()
//        val today = Date(currentTime)
//        val dateFormat = SimpleDateFormat("dd", Locale.getDefault())
//        val date = dateFormat.format(today)
//
//        val sharedPreferences = context.getSharedPreferences("com.example.starbucks", Context.MODE_PRIVATE)
//        val edit = sharedPreferences.edit()
//            edit.putString("Day", date)
//            edit.apply()
//    }
//
//    @Test
//    fun do_not_see_event() {
//        activityScenario.scenario.recreate()
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }

}
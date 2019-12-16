package com.example.lab5

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    val TEXT_BUTTON_1 = "Oi!"
    val TEXT_BUTTON_2 = "Press"
    val TEXT_EDIT = "text edit done"


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test1() {

        //нажатие на кнопку
        onView(withId(R.id.button)).perform(click())
        //провеерка что текст на кнопке изменился
        onView(withId(R.id.button)).check(matches(withText(TEXT_BUTTON_1)))
        //ввод текста в editText
        onView(withId(R.id.editText)).perform(typeText(TEXT_EDIT))
        //поворот экрана
        activityRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        //проверка
        onView(withId(R.id.button)).check(matches(withText(TEXT_BUTTON_2)))
        onView(withId(R.id.editText)).check(matches(withText(TEXT_EDIT)))
    }
}

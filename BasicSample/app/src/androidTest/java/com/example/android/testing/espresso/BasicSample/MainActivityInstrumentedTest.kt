package com.example.android.testing.espresso.BasicSample

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testEntireFlow() {
        // Step 1-2: Type "123" and click "Change Text" button
        onView(withId(R.id.editTextUserInput)).perform(replaceText("123"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Step 3-4: Click "Change Activity" and return to MainActivity
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        pressBack()

        // Step 5-6: Clear text and click "Change Text" button
        onView(withId(R.id.editTextUserInput)).perform(replaceText(""))
        onView(withId(R.id.changeTextBt)).perform(click())

        // Step 7-8: Click "Change Activity" and return to MainActivity
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        pressBack()

        // Step 9-10: Type "abcdef" and click "Change Text" button
        onView(withId(R.id.editTextUserInput)).perform(replaceText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Step 11-12: Click "Change Activity" and return to MainActivity
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        pressBack()
    }
}

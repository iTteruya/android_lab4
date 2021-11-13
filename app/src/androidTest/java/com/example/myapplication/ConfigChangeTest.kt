package com.example.myapplication

import android.content.pm.ActivityInfo
import android.os.SystemClock.sleep
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConfigChangeTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val scenario: ActivityScenario<MainActivity>
        get() = activityRule.scenario

    private fun rotate() {
       scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        sleep(1000)
        activityRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        sleep(1000)
    }

    @Test
    fun firstStateTest() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun secondStateTest() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun thirdStateTest() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun aboutStateTest() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        rotate()
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

}
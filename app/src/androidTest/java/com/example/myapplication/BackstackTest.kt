package com.example.myapplication

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
class BackstackTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val scenario: ActivityScenario<MainActivity>
        get() = activityRule.scenario

    @Test
    fun backFromFirst() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun backFromSecond() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun backFromThird() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun backFromFirstAfterNavigation() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

    @Test
    fun checkAbout() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToFirst)).perform(click())

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        pressBackUnconditionally()

        assertTrue(scenario.state == Lifecycle.State.DESTROYED)
    }

}
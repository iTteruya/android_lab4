package com.example.myapplication

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private fun navigateUp() {
        onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
    }

    private fun canNavigateUp() {
        onView(withContentDescription(R.string.abc_action_bar_up_description))
            .check(matches(isDisplayed()))
    }

    @Test
    fun cannotNavigateUpFromFirst() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withContentDescription(R.string.abc_action_bar_up_description))
            .check(doesNotExist())
    }

    @Test
    fun canNavigateUpFromOtherScreens() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        canNavigateUp()
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        canNavigateUp()
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        canNavigateUp()
    }

    @Test
    fun navigateUpBehavesCorrectly() {
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToSecond)).perform(click())

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        onView(withId(R.id.bnToThird)).perform(click())

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        openAbout()

        onView(withId(R.id.activity_about)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()))
        navigateUp()

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()))
    }
}
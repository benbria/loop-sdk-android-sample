package com.benbria.loopandroidrefapp.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.benbria.loopandroidrefapp.DisableAnimationsRule
import com.benbria.loopandroidrefapp.R
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@LargeTest
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Rule
    @JvmField
    var animationsRule = DisableAnimationsRule()

    @Rule
    @JvmField
    var mGrantPermissionRule =
        GrantPermissionRule.grant()


    @Before
    fun setUp() {

        mActivityTestRule.launchActivity(null)
    }

    @After
    fun tearDown() {
        mActivityTestRule.finishActivity()
    }

    @Test
    fun onCreate() {

        Espresso.onView(withId(R.id.webview_container))
            .check(matches(isDisplayed()))

        Thread.sleep(2000);

        Espresso.onView(withId(R.id.button))
            .check(matches(isDisplayed()))
            .perform(closeSoftKeyboard(),click())

        Espresso.onView(withId(R.id.webview_container))
            .check(matches(isDisplayed()))
            .check(matches(hasChildCount(1)))
    }

}
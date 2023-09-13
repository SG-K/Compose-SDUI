package com.sgk.compose_sdui.base

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
open class BaseTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

//    @get:Rule(order = 1)
//    val composeTestRule = createComposeRule()

    @Before
    open fun setUp(){
        hiltRule.inject()
//        composeTestRule.setContent {
//            FoodAppHomePageSDUITheme {
//                SetContent()
//            }
//        }
    }

}
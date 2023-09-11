package com.sgk.compose_sdui.base

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.compose_sdui.ui.widgets.TextRenderer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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
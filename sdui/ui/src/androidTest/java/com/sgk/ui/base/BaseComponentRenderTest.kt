package com.sgk.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test


abstract class BaseComposeTest<T>() : BaseTest(){

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    val element : T by lazy {
        setData()
    }

    override fun setUp() {
        super.setUp()
        composeTestRule.setContent {
//            FoodAppHomePageSDUITheme {
                SetContent()
//            }
        }
    }

    abstract fun setData() : T

    @Composable
    abstract fun SetContent()

    @Test
    abstract fun testExecution()




}
package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sgk.foodapphomepagesdui.di.RenderJsonTestDataAnnotation
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.squareup.moshi.Moshi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class RenderFromJsonKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    @Inject
    lateinit var moshi: Moshi

    @RenderJsonTestDataAnnotation
    @Inject lateinit var jsonData: String


    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun test(){
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                RenderFromJson(
                    json = jsonData,
                    moshi = moshi
                )
            }
        }
        composeRule.onNodeWithText("Verified").assertIsDisplayed()
        composeRule.onNodeWithText("Apple").assertIsNotDisplayed()
    }

}
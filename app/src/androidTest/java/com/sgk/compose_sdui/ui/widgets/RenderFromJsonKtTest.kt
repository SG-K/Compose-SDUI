package com.sgk.compose_sdui.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.di.RenderJsonTestDataAnnotation
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.squareup.moshi.Moshi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class RenderFromJsonKtTest : BaseComposeTest<String>(){

    @RenderJsonTestDataAnnotation
    @Inject lateinit var jsonData: String

    @Inject
    lateinit var moshi: Moshi

    override fun setData(): String {
        return jsonData
    }

    @Composable
    override fun SetContent() {
        RenderFromJson(
            json = element,
            moshi = moshi
        )
    }

    @Test
    override fun testExecution() {
        composeTestRule.onNodeWithText("Verified").assertIsDisplayed()
        composeTestRule.onNodeWithText("Apple").assertDoesNotExist()
    }

}
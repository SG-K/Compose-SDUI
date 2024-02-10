package com.sgk.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.sgk.ui.base.BaseComposeTest
import com.sgk.ui.di.RenderJsonTestDataAnnotation
import com.squareup.moshi.Moshi
import dagger.hilt.android.testing.HiltAndroidTest
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
        com.sgk.ui.widgets.RenderFromJson(
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
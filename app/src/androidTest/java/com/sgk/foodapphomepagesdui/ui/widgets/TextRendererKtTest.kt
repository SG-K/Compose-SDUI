package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.BackgroundKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.HeightKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.IsTextBoldKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.PaddingKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.TextColorKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.TextSizeKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.WidthKey
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

//https://developer.android.com/jetpack/compose/testing-cheatsheet

@HiltAndroidTest
class TextRendererKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val testTextElement = com.sgk.sduicore.modal.Text(
        text = "Some Text", textStyle = TextStyle(
            textSize = 20,
            isBold = false,
        ), style = ElementStyle(id = "text")
    )

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                TextRenderer(
                    textElement = testTextElement
                )
            }
        }
    }

    @Test
    fun isTextDisplayed(){

        composeRule
            .onNodeWithText("Some Text")
            .assertIsDisplayed()

        composeRule
            .onNode(
                hasTestTag("text")
            )
            .assertExists()

        composeRule
            .onNodeWithText("Verified")
            .assertDoesNotExist()

    }

    @Test
    fun testTextStyleProperties(){

        composeRule
            .onNodeWithText("Some Text")
            .assert(
                SemanticsMatcher.expectValue(TextColorKey, testTextElement.textStyle.textColor)
            )

        composeRule
            .onNodeWithText("Some Text")
            .assert(
                SemanticsMatcher.expectValue(TextSizeKey, testTextElement.textStyle.textSize)
            )

        composeRule
            .onNodeWithText("Some Text")
            .assert(
                SemanticsMatcher.expectValue(IsTextBoldKey, testTextElement.textStyle.isBold)
            )

    }

    @Test
    fun testStylePrperties(){

        testTextElement
            .style
            ?.elementStyleTests(
                composeRule
            )

    }

}

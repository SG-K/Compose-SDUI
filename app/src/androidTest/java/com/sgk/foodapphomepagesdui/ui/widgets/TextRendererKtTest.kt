package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.BackgroundKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.HeightKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.PaddingKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.TextColorKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.TextSizeKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.WidthKey
import com.sgk.sduicore.modal.Text
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

        testTextElement.textStyle.testTextStyle(composeRule,testTextElement.style?.id!!)

//        composeRule
//            .onNodeWithText("Some Text")
//            .assert(
//                SemanticsMatcher.expectValue(TextColorKey, testTextElement.textStyle.textColor)
//            )
//
//        composeRule
//            .onNodeWithText("Some Text")
//            .assert(
//                SemanticsMatcher.expectValue(TextSizeKey, testTextElement.textStyle.textSize)
//            )
//
//        composeRule
//            .onNodeWithText("Some Text")
//            .assert(
//                SemanticsMatcher.expectValue(IsTextBoldKey, testTextElement.textStyle.isBold)
//            )

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

fun Text.testwidget(
    composeRule : ComposeContentTestRule,
){
    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assertExists()
        .assertIsDisplayed()

    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assertTextEquals(text)

    textStyle.testTextStyle(composeRule,style?.id!!)

}

fun TextStyle.testTextStyle(
    composeRule : ComposeContentTestRule,
    id : String
){
    composeRule
        .onNode(hasTestTag(id))
        .assert(
            SemanticsMatcher.expectValue(TextColorKey, textColor)
        )

    composeRule
        .onNode(hasTestTag(id))
        .assert(
            SemanticsMatcher.expectValue(TextSizeKey, textSize)
        )

    composeRule
        .onNode(hasTestTag(id))
        .assert(
            SemanticsMatcher.expectValue(IsTextBoldKey, isBold)
        )
}

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
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.TextColorKey
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.TextSizeKey
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
    fun testText(){
        testTextElement.testWidget(composeRule)
    }

}

fun Text.testWidget(
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

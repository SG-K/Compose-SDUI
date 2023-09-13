package com.sgk.compose_sdui.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.ui.widgets.utils.semantics.TextColorKey
import com.sgk.ui.widgets.utils.semantics.TextSizeKey
import com.sgk.model.modal.Text
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

//https://developer.android.com/jetpack/compose/testing-cheatsheet

@HiltAndroidTest
class TextRendererKtTest : BaseComposeTest<Text>() {

     override fun setData(): Text {
        return Text(
            text = "Some Text", textStyle = TextStyle(
                textSize = 20,
                isBold = false,
            ), style = ElementStyle(id = "text")
        )
    }

    @Composable
    override fun SetContent() {
        com.sgk.ui.widgets.TextRenderer(
            textElement = element
        )
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
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
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.TextColorKey, textColor)
        )

    composeRule
        .onNode(hasTestTag(id))
        .assert(
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.TextSizeKey, textSize)
        )

    composeRule
        .onNode(hasTestTag(id))
        .assert(
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.IsTextBoldKey, isBold)
        )
}

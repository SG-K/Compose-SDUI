package com.sgk.compose_sdui.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.model.modal.Row
import com.sgk.model.modal.Text
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class RowRendererKtTest : BaseComposeTest<Row>(){

    override fun setData(): Row {
        return Row(
            children = listOf(
                Text(
                    text = "Lorem",
                    textStyle = TextStyle(
                        textSize = 24,
                        isBold = true,
                    ),
                    style = ElementStyle(
                        id = "11"
                    )
                ),
                Text(
                    text = "ipsum",
                    textStyle = TextStyle(
                        textSize = 14,
                        isBold = false,
                    ),
                    style = ElementStyle(
                        id = "22",
                        padding = Padding(
                            top = 12,
                            bottom = 12,
                            left = 12,
                            right = 12
                        )
                    )
                ),

                ),
            style = ElementStyle(
                id = "row",
                background = "#FFFFFF",
                padding = Padding(
                    top = 12,
                    bottom = 12,
                    left = 12,
                    right = 12
                )
            )
        )
    }
    
    @Composable
    override fun SetContent() {
        RowRenderer(element = element)
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
        testRowContents()
    }
    
    fun testRowContents(){

        val child1 = element.children[0] as Text
        val child2 = element.children[1] as Text

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .assertCountEquals(2)

        val childern = composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()

        childern
            .onFirst()
            .assertTextEquals(child1.text)
            .assert(
                SemanticsMatcher.expectValue(IsTextBoldKey, child1.textStyle.isBold)
            )

        childern
            .onLast()
            .assertTextEquals(child2.text)
            .assert(
                SemanticsMatcher.expectValue(IsTextBoldKey, child2.textStyle.isBold)
            )

        child1.testWidget(composeTestRule)
        child2.testWidget(composeTestRule)

    }

}


fun Row.testWidget(
    composeRule : ComposeContentTestRule,
){

    composeRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeRule)

}
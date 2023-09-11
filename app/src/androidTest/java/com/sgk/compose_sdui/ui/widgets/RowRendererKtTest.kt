package com.sgk.compose_sdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.compose_sdui.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class RowRendererKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val rowElementData = Row(
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

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                RowRenderer(element = rowElementData)
            }
        }
    }

    @Test
    fun testRowDisplay(){
        rowElementData.testWidget(composeRule)
    }

    @Test
    fun testRowContents(){

        val child1 = rowElementData.children[0] as Text
        val child2 = rowElementData.children[1] as Text

        composeRule
            .onNode(hasTestTag(rowElementData.style?.id?:""))
            .onChildren()
            .assertCountEquals(2)

        val childern = composeRule
            .onNode(hasTestTag(rowElementData.style?.id?:""))
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

        child1.testWidget(composeRule)
        child2.testWidget(composeRule)

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
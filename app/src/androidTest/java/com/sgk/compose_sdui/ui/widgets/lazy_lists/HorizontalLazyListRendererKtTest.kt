package com.sgk.compose_sdui.ui.widgets.lazy_lists

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
import com.sgk.compose_sdui.ui.widgets.LazyListRenderer
import com.sgk.compose_sdui.ui.widgets.elementStyleTests
import com.sgk.compose_sdui.ui.widgets.utils.semantics.IsTextBoldKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.OrientationKey
import com.sgk.sduicore.modal.LazyElement
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HorizontalLazyListRendererKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val horizontalListData = LazyList(
        orientation = Orientation.HORIZONTAL,
        style = ElementStyle(
            id = "horizontal_list",
            padding = Padding(
                top = 12,
                bottom = 12,
                left = 12,
                right = 12
            )
        ),
        children = listOf(
            LazyElement(
                lazyElemntId = "1",
                element = Text(
                    text = "Lorem",
                    textStyle = TextStyle(
                        textSize = 24,
                        isBold = true,
                    ),
                    style = ElementStyle(
                        id = "11",
                        padding = Padding(
                            top = 12,
                            bottom = 12,
                            left = 12,
                            right = 12
                        )
                    )
                )
            ),
            LazyElement(
                lazyElemntId = "2",
                element = Text(
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
                )
            ),
            LazyElement(
                lazyElemntId = "3",
                element = Text(

                    text = "dolor sit amet",
                    textStyle = TextStyle(
                        textSize = 10,
                        isBold = false,
                    ),
                    style = ElementStyle(
                        id = "33",
                        padding = Padding(
                            top = 12,
                            bottom = 12,
                            left = 12,
                            right = 12
                        )
                    )
                )
            ),
        ),
    )

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                LazyListRenderer(element = horizontalListData)
            }
        }
    }

    @Test
    fun testLazyListDisplay(){
        horizontalListData.testWidget(composeRule)
    }

    @Test
    fun testLazyListContent(){

        val child1 = horizontalListData.children[0].element as Text
        val child2 = horizontalListData.children[1].element as Text
        val child3 = horizontalListData.children[2].element as Text

        composeRule
            .onNode(hasTestTag(horizontalListData.style?.id?:""))
            .assert(
                SemanticsMatcher.expectValue(OrientationKey, horizontalListData.orientation)
            )
            .onChildren()
            .assertCountEquals(3)

        val childern = composeRule
            .onNode(hasTestTag(horizontalListData.style?.id?:""))
            .onChildren()

        childern
            .onFirst()
            .assert(
                hasTestTag(child1.style?.id?:"")
            )
            .assertExists()
            .assertIsDisplayed()
            .assertTextEquals(child1.text?:"")
            .assert(
                SemanticsMatcher.expectValue(
                    IsTextBoldKey,
                    child1.textStyle.isBold
                )
            )

        childern[1]
            .assert(
                hasTestTag(child2.style?.id?:"")
            )
            .assertExists()
            .assertIsDisplayed()
            .assertTextEquals(child2.text?:"")
            .assert(
                SemanticsMatcher.expectValue(
                    IsTextBoldKey,
                    child2.textStyle.isBold
                )
            )

        childern
            .onLast()
            .assert(
                hasTestTag(child3.style?.id?:"")
            )
            .assertExists()
            .assertIsDisplayed()
            .assertTextEquals(child3.text?:"")
            .assert(
                SemanticsMatcher.expectValue(
                    IsTextBoldKey,
                    child3.textStyle.isBold
                )
            )

    }

}

fun LazyList.testWidget(
    composeRule : ComposeContentTestRule,
){

    composeRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeRule)

    composeRule
        .onNode(hasTestTag(style?.id?:""))
        .assert(
            SemanticsMatcher.expectValue(OrientationKey, orientation)
        )

    Assert.assertNotEquals(0,children.size)

}
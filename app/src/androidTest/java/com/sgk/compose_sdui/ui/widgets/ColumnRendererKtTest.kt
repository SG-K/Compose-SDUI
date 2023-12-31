package com.sgk.compose_sdui.ui.widgets

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
import com.sgk.sduicore.modal.Column
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
class ColumnRendererKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val columnElement = Column(
        style = ElementStyle(
            id = "column"
        ),
        children = listOf(
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                textStyle = TextStyle(
                    textSize = 24,
                    isBold = true,
                ), style = ElementStyle(
                    id = "child1",
                    padding = Padding(
                        top = 12,
                        bottom = 12,
                        left = 12,
                        right = 12
                    )
                )
            ),
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ullamcorper sodales erat vel egestas. In nec diam non est volutpat convallis et ut urna. Aliquam ante libero, sollicitudin dictum magna sit amet, pharetra semper justo. Sed gravida, odio vitae iaculis dignissim, turpis metus faucibus nisi, non aliquam tellus erat et tortor. Duis egestas metus in nisi scelerisque, eu gravida lectus iaculis. Morbi eu nisl dolor. Nullam vel turpis porttitor tellus consequat lobortis. Cras lobortis lectus vel turpis feugiat, ut euismod odio venenatis.",
                textStyle = TextStyle(
                    textSize = 14,
                    isBold = false,
                ),
                style = ElementStyle(
                    id = "child2",
                    padding = Padding(
                        top = 12,
                        bottom = 12,
                        left = 12,
                        right = 12
                    )
                )
            )
        )
    )


    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                ColumnRenderer(element = columnElement)
            }
        }
    }

    @Test
    fun testColomDisplay(){
        columnElement.testWidget(composeRule)
    }

    @Test
    fun testColumnContents(){

        val child1 = columnElement.children[0] as Text
        val child2 = columnElement.children[1] as Text

        val childern = composeRule
            .onNode(hasTestTag(columnElement.style?.id?:""))
            .onChildren()

        childern
            .assertCountEquals(2)
            .onFirst()
            .assertTextEquals(child1.text)


        childern
            .onLast()
            .assertTextEquals(child2.text)

        child1.testWidget(composeRule)
        child2.testWidget(composeRule)

    }

}

fun Column.testWidget(
    composeRule : ComposeContentTestRule
){

    composeRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeRule)

}
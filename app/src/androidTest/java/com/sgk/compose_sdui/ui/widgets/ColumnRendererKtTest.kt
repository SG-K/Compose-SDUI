package com.sgk.compose_sdui.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import com.sgk.compose_sdui.base.BaseComposeTest
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
class ColumnRendererKtTest : BaseComposeTest<Column>(){

    override fun setData(): Column {
        return Column(
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
    }

    @Composable
    override fun SetContent() {
        ColumnRenderer(element = element)
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
    }
    
    fun testColumnContents(){

        val child1 = element.children[0] as Text
        val child2 = element.children[1] as Text

        val childern = composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()

        childern
            .assertCountEquals(2)
            .onFirst()
            .assertTextEquals(child1.text)


        childern
            .onLast()
            .assertTextEquals(child2.text)

        child1.testWidget(composeTestRule)
        child2.testWidget(composeTestRule)

    }

}

fun Column.testWidget(
    composeTestRule : ComposeContentTestRule
){

    composeTestRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeTestRule)

}
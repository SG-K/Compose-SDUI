package com.sgk.ui.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onChild
import com.sgk.ui.base.BaseComposeTest
import com.sgk.ui.widgets.utils.semantics.CardContentColorKey
import com.sgk.ui.widgets.utils.semantics.CardElevationKey
import com.sgk.ui.widgets.utils.semantics.CardRadiusKey
import com.sgk.model.modal.Card
import com.sgk.model.modal.Card as CardElement
import com.sgk.model.modal.CardStyle
import com.sgk.model.modal.Text
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Length
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class CardRendererKtTest : BaseComposeTest<Card>(){

    override fun setData(): Card {
        return CardElement(
            style = ElementStyle(
                id = "card",
                width = Length.Number(300),
                height = Length.Number(350),
                padding = Padding(
                    top = 12,
                    bottom = 12,
                    left = 12,
                    right = 12
                )
            ),
            cardStyle = CardStyle(
                radius = 10,
                contentColor = "#FF0000",
                elevation = 2
            ),
            child = Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ullamcorper sodales erat vel egestas. In nec diam non est volutpat convallis et ut urna. Aliquam ante libero, sollicitudin dictum magna sit amet, pharetra semper justo. Sed gravida, odio vitae iaculis dignissim, turpis metus faucibus nisi, non aliqui scelerisque, eu grvel turpis porttitor tellnenatis.",
                textStyle = TextStyle(
                    textSize = 20,
                    isBold = false,
                ),
                style = ElementStyle(
                    id = "sds",
                    width = Length.Number(60),
                    height = Length.Number(30),
                    padding = Padding(
                        top = 12,
                        bottom = 12,
                        left = 12,
                        right = 12
                    ),
                    background = "#0000FF"
                )
            )
        )
    }


    @Composable
    override fun SetContent() {
        CardRenderer(element = element)
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
        testCardContents()
    }

    fun testCardContents(){

        val text = element.child as Text
        text.style?.id?.let {
            composeTestRule
                .onNode(hasTestTag("card"))
                .onChild()
                .assert(hasTestTag(it))
                .assertTextEquals(text.text)
        }

    }



}


fun Card.testWidget(
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
        .assert(
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.CardRadiusKey, cardStyle?.radius)
        )

    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assert(
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.CardElevationKey, cardStyle?.elevation)
        )

    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assert(
            SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.CardContentColorKey, cardStyle?.contentColor)
        )

    style?.elementStyleTests(composeRule)

    child.style?.id?.let {
        composeRule
            .onNode(hasTestTag(style?.id!!))
            .onChild()
            .assert(hasTestTag(it))
    }

}
package com.sgk.compose_sdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.compose_sdui.ui.widgets.utils.semantics.CardContentColorKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.CardElevationKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.CardRadiusKey
import com.sgk.sduicore.modal.Card
import com.sgk.sduicore.modal.Card as CardElement
import com.sgk.sduicore.modal.CardStyle
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CardRendererKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val cardRenderData : CardElement = CardElement(
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


    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                CardRenderer(element = cardRenderData)
            }
        }
    }

    @Test
    fun isCardDisplayed(){

        composeRule
            .onNode(
                hasTestTag("card")
            )
            .assertExists()
            .assertIsDisplayed()

    }

    @Test
    fun testCardStyle(){
        composeRule
            .onNode(
                hasTestTag("card")
            )
            .assert(
                SemanticsMatcher.expectValue(CardRadiusKey, cardRenderData.cardStyle?.radius)
            )

        composeRule
            .onNode(
                hasTestTag("card")
            )
            .assert(
                SemanticsMatcher.expectValue(CardElevationKey, cardRenderData.cardStyle?.elevation)
            )

        composeRule
            .onNode(
                hasTestTag("card")
            )
            .assert(
                SemanticsMatcher.expectValue(CardContentColorKey, cardRenderData.cardStyle?.contentColor)
            )
    }

    @Test
    fun testElementStyle(){
//        val style = cardRenderData.copy(
//            style = cardRenderData.style?.copy(
//                padding = Padding(
//                    top = 1,
//                    bottom = 1,
//                    left = 1,
//                    right = 1
//                )
//            )
//        )
//        style.style?.elementStyleTests(composeRule)
        cardRenderData.style?.elementStyleTests(composeRule)
    }

    @Test
    fun testCardContents(){

        val text = cardRenderData.child as Text
        text.style?.id?.let {
            composeRule
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
            SemanticsMatcher.expectValue(CardRadiusKey, cardStyle?.radius)
        )

    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assert(
            SemanticsMatcher.expectValue(CardElevationKey, cardStyle?.elevation)
        )

    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assert(
            SemanticsMatcher.expectValue(CardContentColorKey, cardStyle?.contentColor)
        )

    style?.elementStyleTests(composeRule)

    child.style?.id?.let {
        composeRule
            .onNode(hasTestTag(style?.id!!))
            .onChild()
            .assert(hasTestTag(it))
    }

}
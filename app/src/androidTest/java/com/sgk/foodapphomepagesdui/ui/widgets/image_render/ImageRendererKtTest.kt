package com.sgk.foodapphomepagesdui.ui.widgets.image_render

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.foodapphomepagesdui.ui.widgets.ImageRenderer
import com.sgk.foodapphomepagesdui.ui.widgets.elementStyleTests
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.ImageTypeKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.ImageUrlKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.TintKey
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class ImageRendererKtTest{


    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val imageElement = Image(
        altText = "some altText",
        url = "https://images.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png",
        imageType = ImageType.REMOTE,
        tint = "#FF0000",
        style = ElementStyle(
            width = Length.Number(48),
            height = Length.Number(48),
            id = "image",
            padding = Padding(
                left = 24,
                right = 24,
                top = 24,
                bottom = 24,
            )
        )
    )


    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                ImageRenderer(
                    imgElement = imageElement
                )
            }
        }
    }

    @Test
    fun testImageDisplay(){
        composeRule
            .onNode(hasTestTag(imageElement.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun testImageType(){
        composeRule
            .onNode(hasTestTag(imageElement.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(ImageTypeKey, imageElement.imageType)
            )
    }

    @Test
    fun testImageUrl(){
        composeRule
            .onNode(hasTestTag(imageElement.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(ImageUrlKey, imageElement.url)
            )
    }

    @Test
    fun testImageContentDesp(){
        composeRule
            .onNode(hasTestTag(imageElement.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assertContentDescriptionEquals(imageElement.altText!!)
    }

    @Test
    fun testImageTint(){
        composeRule
            .onNode(hasTestTag(imageElement.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(TintKey, imageElement.tint)
            )
    }

    @Test
    fun imageStyleTests(){
        imageElement.style?.elementStyleTests(composeRule)
    }


}
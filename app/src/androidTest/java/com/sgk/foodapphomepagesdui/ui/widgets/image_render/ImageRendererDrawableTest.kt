package com.sgk.foodapphomepagesdui.ui.widgets.image_render

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.foodapphomepagesdui.ui.widgets.ImageRenderer
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.ImageTypeKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.ImageUrlKey
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
class ImageRendererDrawableTest {


    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val imageElementDrawable = Image(
        altText = "some altText",
        url = "facebook",
        imageType = ImageType.DRAWABLE,
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
                    imgElement = imageElementDrawable
                )
            }
        }
    }

    @Test
    fun testImageTypeDrawable(){
        composeRule
            .onNode(hasTestTag(imageElementDrawable.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(ImageTypeKey, imageElementDrawable.imageType)
            )
    }

    @Test
    fun testImageUrlDrawable(){
        composeRule
            .onNode(hasTestTag(imageElementDrawable.style?.id!!))
            .assertExists()
            .assertIsDisplayed()
            .assert(
                SemanticsMatcher.expectValue(ImageUrlKey, imageElementDrawable.url)
            )
    }


}
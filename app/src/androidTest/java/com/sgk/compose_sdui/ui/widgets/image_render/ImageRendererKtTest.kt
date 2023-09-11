package com.sgk.compose_sdui.ui.widgets.image_render

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.ui.widgets.ImageRenderer
import com.sgk.compose_sdui.ui.widgets.elementStyleTests
import com.sgk.compose_sdui.ui.widgets.utils.semantics.ImageTypeKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.ImageUrlKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.TintKey
import com.sgk.compose_sdui.ui.widgets.utils.semantics.VectorUrlKey
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class ImageRendererKtTest : BaseComposeTest<Image>() {

    override fun setData(): Image {
        return Image(
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
    }

    @Composable
    override fun SetContent() {
        ImageRenderer(
            imgElement = element
        )
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
    }


}


fun Image.testWidget(
    composeRule : ComposeContentTestRule,
    imageVector: ImageVector? = null
){
    composeRule
        .onNode(
            hasTestTag(style?.id!!)
        )
        .assertExists()
        .assertIsDisplayed()

    composeRule
        .onNode(hasTestTag(style?.id!!))
        .assertExists()
        .assertIsDisplayed()
        .assert(
            SemanticsMatcher.expectValue(ImageTypeKey, imageType)
        )

    composeRule
        .onNode(hasTestTag(style?.id!!))
        .assertExists()
        .assertIsDisplayed()
        .assertContentDescriptionEquals(altText?:"")

    composeRule
        .onNode(hasTestTag(style?.id!!))
        .assertExists()
        .assertIsDisplayed()
        .assert(
            SemanticsMatcher.expectValue(TintKey, tint)
        )

    composeRule
        .onNode(hasTestTag(style?.id!!))
        .assertExists()
        .assertIsDisplayed()
        .assert(
            SemanticsMatcher.expectValue(ImageUrlKey, url)
        )


    style?.elementStyleTests(composeRule)

    imageVector?.let {
        composeRule
            .onNode(hasTestTag(style?.id!!))
            .assertExists()
            .assert(
                SemanticsMatcher.expectValue(VectorUrlKey, it)
            )
    }

}
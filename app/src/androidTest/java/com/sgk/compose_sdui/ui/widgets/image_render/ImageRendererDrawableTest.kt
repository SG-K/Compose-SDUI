package com.sgk.compose_sdui.ui.widgets.image_render

import androidx.compose.runtime.Composable
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.ui.widgets.ImageRenderer
import com.sgk.model.modal.Image
import com.sgk.model.modal.ImageType
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Length
import com.sgk.model.modal.metadata.Padding
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test

@HiltAndroidTest
class ImageRendererDrawableTest : BaseComposeTest<Image>() {

    override fun setData(): Image {
        return Image(
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
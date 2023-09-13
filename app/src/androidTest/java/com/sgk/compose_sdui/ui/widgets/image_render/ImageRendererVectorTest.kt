package com.sgk.compose_sdui.ui.widgets.image_render

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.ui.widgets.ImageRenderer
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test


@HiltAndroidTest
class ImageRendererVectorTest : BaseComposeTest<Image>(){

    override fun setData(): Image {
        return Image(
            altText = "some altText",
            url = "check",
            imageType = ImageType.IMAGE_VECTOR,
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
        element.testWidget(composeTestRule,imageVector = Icons.Outlined.Check)
    }


}

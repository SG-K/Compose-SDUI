package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.Image as ImageElement
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.compose_sdui.helper.toColor
import com.sgk.compose_sdui.ui.widgets.image.getImageVector
import com.sgk.compose_sdui.ui.widgets.image.getPaintResource
import com.sgk.compose_sdui.ui.widgets.utils.semantics.addTestSemantics

@Composable
fun ImageRenderer(imgElement: ImageElement) {

  val modifier = imgElement
    .style
    .asModifier()
    .addTestSemantics(imgElement)


  when(imgElement.imageType){
    ImageType.DRAWABLE -> {
      Image(
        modifier = modifier,
        painter = imgElement
          .url
          .getPaintResource(),
        contentDescription = imgElement.altText,
        contentScale = ContentScale.FillBounds,
        colorFilter = imgElement.tint?.toColor()?.let {
          ColorFilter.tint(it)
        }
      )
    }
    ImageType.IMAGE_VECTOR -> {
      Image(
        modifier = modifier,
        imageVector = imgElement
          .url
          .getImageVector(),
        contentDescription = imgElement.altText,
        contentScale = ContentScale.FillBounds,
        colorFilter = imgElement.tint?.toColor()?.let {
          ColorFilter.tint(it)
        }
      )
    }
    ImageType.REMOTE -> {
      AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
          .data(imgElement.url)
          .build(),
        contentDescription = imgElement.altText,
        contentScale = ContentScale.FillBounds,
        colorFilter = imgElement.tint?.toColor()?.let {
          ColorFilter.tint(it)
        }
      )
    }
  }

}

@Preview(name = "Image", "Layout Components")
@Composable
fun ImageRendererPreview() {
  ImageRenderer(
    imgElement = ImageElement(
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
  )
}
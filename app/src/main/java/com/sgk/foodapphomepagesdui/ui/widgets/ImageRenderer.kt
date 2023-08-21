package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.Image as ImageElement
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.foodapphomepagesdui.helper.toColor
import com.sgk.foodapphomepagesdui.ui.widgets.image.getImageVector
import com.sgk.foodapphomepagesdui.ui.widgets.image.getPaintResource
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.background
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.height
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.imageType
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.imageUrl
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.isTextBold
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.layoutId
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.padding
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.textColor
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.textSize
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.tint
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.vectorUrl
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.width

@Composable
fun ImageRenderer(imgElement: ImageElement) {

  val modifier = imgElement
    .style
    .asModifier()
    .semantics {
      imageUrl = imgElement.url
      imageType = imgElement.imageType
      tint = imgElement.tint
      width = imgElement.style?.width
      height = imgElement.style?.height
      background = imgElement.style?.background
      padding = imgElement.style?.padding
      layoutId = imgElement.style?.id
      vectorUrl = imgElement.url.getImageVector()
    }


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
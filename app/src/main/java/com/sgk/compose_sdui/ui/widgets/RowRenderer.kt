package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.sduicore.modal.metadata.Background
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.Row as RowElement

@Composable
fun RowRenderer(element: RowElement) {
  Row(
    modifier = element.style.asModifier(),
    verticalAlignment =  element.alignment.getRowAlignment()
  ) {
    element.children.forEach { child ->
      CompositeRenderer(element = child)
    }
  }
}

fun com.sgk.sduicore.modal.Alignment.getRowAlignment() : Alignment.Vertical {
  return when(this){
    com.sgk.sduicore.modal.Alignment.CENTER_VERTICAL -> Alignment.CenterVertically
    com.sgk.sduicore.modal.Alignment.BOTTOM -> Alignment.Bottom
    else -> Alignment.Top
  }
}

fun com.sgk.sduicore.modal.Alignment.getAlignment() : Alignment {
  return when(this){
    com.sgk.sduicore.modal.Alignment.TOP_START -> Alignment.TopStart 
    com.sgk.sduicore.modal.Alignment.TOP_CENTER -> Alignment.TopCenter 
    com.sgk.sduicore.modal.Alignment.TOP_END -> Alignment.TopEnd 
    com.sgk.sduicore.modal.Alignment.CENTER_START -> Alignment.CenterStart 
    com.sgk.sduicore.modal.Alignment.CENTER -> Alignment.Center 
    com.sgk.sduicore.modal.Alignment.CENTER_END -> Alignment.CenterEnd 
    com.sgk.sduicore.modal.Alignment.BOTTOM_START -> Alignment.BottomStart 
    com.sgk.sduicore.modal.Alignment.BOTTOM_CENTER -> Alignment.BottomCenter 
    com.sgk.sduicore.modal.Alignment.BOTTOM_END -> Alignment.BottomEnd 
    else -> Alignment.TopStart 
  }
}

@Preview(name = "Row", "Layout Components")
@Composable
fun RowRendererPreview() {
  RowRenderer(
    element = RowElement(
      children = listOf(
        TextElement(
          text = "Lorem",
          textStyle = TextStyle(
            textSize = 24,
            isBold = true,
          ),
          style = ElementStyle(
            id = "11"
          )
        ),
        TextElement(
          text = "ipsum",
          textStyle = TextStyle(
            textSize = 14,
            isBold = false,
          ),
          style = ElementStyle(
            id = "22",
            padding = Padding(
              top = 12,
              bottom = 12,
              left = 12,
              right = 12
            )
          )
        ),

        ),
      style = ElementStyle(
        id = "row",
        background = Background(colors = arrayListOf("#FFFFFF")),
        padding = Padding(
          top = 12,
          bottom = 12,
          left = 12,
          right = 12
        )
      )
    )
  )
}

package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.sduicore.modal.metadata.ElementBackground
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.Row as RowElement

@Composable
fun RowRenderer(element: RowElement) {
  Row(
    modifier = element.style.asModifier(),
  ) {
    element.children.forEach { child ->
      CompositeRenderer(element = child)
    }
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
        background = ElementBackground(colors = arrayListOf("#FFFFFF")),
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

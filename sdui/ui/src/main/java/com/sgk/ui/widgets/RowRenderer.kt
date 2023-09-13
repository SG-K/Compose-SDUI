package com.sgk.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle
import com.sgk.model.modal.Text as TextElement
import com.sgk.model.modal.Row as RowElement

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
        background = "#FFFFFF",
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
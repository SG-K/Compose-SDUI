package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
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
//  RowRenderer(
//    element = RowElement(
//      children = listOf(
//        TextElement(
//          text = "Lorem",
//          textStyle = TextStyle(
//            textSize = 24,
//            isBold = true,
//          ), style = null
//        ),
//        TextElement(
//          text = "ipsum",
//          textStyle = TextStyle(
//            textSize = 14,
//            isBold = false,
//          ),
//          style = ElementStyle(
//            padding = Padding(
//              top = 12,
//              bottom = 12,
//              left = 12,
//              right = 12
//            )
//          )
//        ),
//
//      )
//    )
//  )
}

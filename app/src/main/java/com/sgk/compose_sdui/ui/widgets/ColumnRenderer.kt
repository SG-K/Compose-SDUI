package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Column as ColumnElement

@Composable
fun ColumnRenderer(element: ColumnElement) {
  Column(
    modifier = element.asModifier(),
  ) {
    element.children.forEach { child ->
      CompositeRenderer(element = child)
    }
  }
}

@Preview(name = "Column", "Layout Components")
@Composable
fun ColumnPreview() {

  ColumnRenderer(
    element = ColumnElement(
      children = listOf(
        TextElement(
          text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
          textStyle = TextStyle(
            textSize = 24,
            isBold = true,
          ), style = ElementStyle(
            padding = Padding(
              top = 12,
              bottom = 12,
              left = 12,
              right = 12
            )
          )
        ),
        TextElement(
          text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ullamcorper sodales erat vel egestas. In nec diam non est volutpat convallis et ut urna. Aliquam ante libero, sollicitudin dictum magna sit amet, pharetra semper justo. Sed gravida, odio vitae iaculis dignissim, turpis metus faucibus nisi, non aliquam tellus erat et tortor. Duis egestas metus in nisi scelerisque, eu gravida lectus iaculis. Morbi eu nisl dolor. Nullam vel turpis porttitor tellus consequat lobortis. Cras lobortis lectus vel turpis feugiat, ut euismod odio venenatis.",
          textStyle = TextStyle(
            textSize = 14,
            isBold = false,
          ),
          style = ElementStyle(
            padding = Padding(
              top = 12,
              bottom = 12,
              left = 12,
              right = 12
            )
          )
        )
      )
    )
  )


//  ColumnRenderer(
//    element = ColumnElement(
//      children = listOf(
//        TextElement(
//          text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
//          textStyle = TextStyle(
//            textSize = 24,
//            isBold = true,
//          ), style = null
//        ),
//        TextElement(
//          text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ullamcorper sodales erat vel egestas. In nec diam non est volutpat convallis et ut urna. Aliquam ante libero, sollicitudin dictum magna sit amet, pharetra semper justo. Sed gravida, odio vitae iaculis dignissim, turpis metus faucibus nisi, non aliquam tellus erat et tortor. Duis egestas metus in nisi scelerisque, eu gravida lectus iaculis. Morbi eu nisl dolor. Nullam vel turpis porttitor tellus consequat lobortis. Cras lobortis lectus vel turpis feugiat, ut euismod odio venenatis.",
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
//        ButtonElement(
//          text = "Submit",
//          textStyle = TextStyle(textSize = 20),
//          buttonStyle = ButtonStyle.FILLED,
//          color = "#5accf6"
//        )
//      )
//    )
//  )
}
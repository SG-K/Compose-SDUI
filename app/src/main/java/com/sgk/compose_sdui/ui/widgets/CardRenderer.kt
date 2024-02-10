package com.sgk.compose_sdui.ui.widgets

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.compose_sdui.helper.toColor
import com.sgk.compose_sdui.ui.widgets.utils.semantics.addTestSemantics
import com.sgk.sduicore.modal.metadata.Background
import com.sgk.sduicore.modal.Card as CardElement

@Composable
fun CardRenderer(element: CardElement) {

  val modifier = element
    .style
    .asModifier()
    .addTestSemantics(element)

  if (element.style?.id == "row_book_now"){
    Log.v("sdvsdvsdv", "contentColor = ${element.cardStyle?.contentColor}")
    Log.v("sdvsdvsdv", "containerColor = ${element.cardStyle?.containerColor}")
  }

  Card(
    modifier = modifier ,
    shape = RoundedCornerShape(size = element.cardStyle?.radius?.dp ?: 0.dp),
    elevation = CardDefaults.cardElevation(
      defaultElevation = element.cardStyle?.elevation?.dp ?: 0.dp
    ),
    colors = CardDefaults.cardColors(
      contentColor = element.cardStyle?.contentColor?.toColor() ?: Color.White,
      containerColor = element.cardStyle?.containerColor?.toColor() ?: Color.White
    )
  ) {

    CompositeRenderer(element = element.child)
  }
}

@Preview(name = "Card", "Layout Components")
@Composable
fun CardRendererPreview() {
  CardRenderer(
    element = CardElement(
      style = ElementStyle(
        id = "card",
        width = Length.Number(300),
        height = Length.Number(350),
        padding = Padding(
          top = 12,
          bottom = 12,
          left = 12,
          right = 12
        )
      ),
      cardStyle = com.sgk.sduicore.modal.CardStyle(
        radius = 10,
        contentColor = "#FF0000",
        elevation = 2,
        containerColor = "#FF0000"
      ),
      child = TextElement(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut ullamcorper sodales erat vel egestas. In nec diam non est volutpat convallis et ut urna. Aliquam ante libero, sollicitudin dictum magna sit amet, pharetra semper justo. Sed gravida, odio vitae iaculis dignissim, turpis metus faucibus nisi, non aliqui scelerisque, eu grvel turpis porttitor tellnenatis.",
        textStyle = TextStyle(
          textSize = 20,
          isBold = false,
        ),
        style = ElementStyle(
          id = "sds",
          width = Length.Number(60),
          height = Length.Number(30),
          padding = Padding(
            top = 12,
            bottom = 12,
            left = 12,
            right = 12
          ),
          background = Background(colors = arrayListOf("#0000FF"))
        )
      )
    )
  )
}

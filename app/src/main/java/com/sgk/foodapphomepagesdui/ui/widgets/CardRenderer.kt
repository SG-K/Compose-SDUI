package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgk.sduicore.modal.CardStyle
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.foodapphomepagesdui.helper.toColor
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.addTestSemantics
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.cardContentColor
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.cardElevation
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.cardRadius
import com.sgk.sduicore.modal.Card as CardElement

@Composable
fun CardRenderer(element: CardElement) {

  val modifier = element
    .style
    .asModifier()
    .addTestSemantics(element)

  Card(
    modifier = modifier ,
    shape = RoundedCornerShape(size = element.cardStyle?.radius?.dp ?: 0.dp),
    elevation = CardDefaults.cardElevation(
      defaultElevation = element.cardStyle?.elevation?.dp ?: 0.dp
    ),
    colors = CardDefaults.cardColors(
      containerColor = element.cardStyle?.contentColor?.toColor() ?: Color.White
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
        elevation = 2
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
          background = "#0000FF"
        )
      )
    )
  )
}

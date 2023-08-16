package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sgk.foodapphomepagesdui.helper.toColor
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement

@Composable
fun TextRenderer(textElement: TextElement) {

  Text(
    text = textElement.text,
    fontSize = textElement.textStyle.textSize.sp,
    fontWeight = if (textElement.textStyle.isBold == true)
      FontWeight.Bold
    else
      FontWeight.Normal,
    color = textElement.textStyle.textColor?.toColor() ?: Color.Unspecified,
    modifier = textElement
      .style
      ?.asModifier()
      ?.layoutId(textElement.id) ?: Modifier.layoutId(textElement.id)
  )
}

@Preview(name = "Text", "Text Components")
@Composable
fun TextRendererPreview() {
  TextRenderer(
    textElement = TextElement(
      text = "Some Text", textStyle = TextStyle(
        textSize = 20,
        isBold = false,
      ), style = null, id = "text"
    )
  )
}
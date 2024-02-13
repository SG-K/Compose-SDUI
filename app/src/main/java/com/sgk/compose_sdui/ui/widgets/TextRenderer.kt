package com.sgk.compose_sdui.ui.widgets

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sgk.compose_sdui.helper.toColor
import com.sgk.compose_sdui.ui.theme.getFont
import com.sgk.compose_sdui.ui.theme.getFontFamily
import com.sgk.compose_sdui.ui.theme.oscineFont
import com.sgk.compose_sdui.ui.widgets.utils.semantics.addTestSemantics
import com.sgk.sduicore.adapters.constraint_layout.print
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.metadata.TextAlign as SduiTextAlign
import com.sgk.sduicore.modal.metadata.TextAlign.LEFT as LEFT
import com.sgk.sduicore.modal.metadata.TextAlign.RIGHT as RIGHT
import com.sgk.sduicore.modal.metadata.TextAlign.CENTER as CENTER

@Composable
fun TextRenderer(textElement: TextElement) {

  if (textElement.style?.id == "text_book_now_desp"){
    Log.v("hjdsvbsjdhbv", "fontWeight = ${textElement.textStyle.fontWeight}")
  }

  "sdvfdfv json data = ${textElement.textStyle.align}".print()

  Text(
    text = textElement.text,
    fontSize = textElement.textStyle.textSize.sp,
    fontWeight = textElement.textStyle.fontWeight?.let{ FontWeight(it) },
    color = textElement.textStyle.textColor?.toColor() ?: Color.Unspecified,
    lineHeight = textElement.textStyle.lineHeight?.sp ?: TextUnit.Unspecified,
    fontFamily = textElement.textStyle.fontFamily?.getFontFamily(),
    modifier = textElement
      .style
      .asModifier()
      .addTestSemantics(textElement),
    textAlign = textElement.textStyle.align?.toComposeTextAlign() ?: TextAlign.Left
  )
}

fun SduiTextAlign.toComposeTextAlign() = when(this){
  LEFT -> TextAlign.Left
  CENTER -> TextAlign.Center
  CENTER -> TextAlign.Center
  RIGHT -> TextAlign.Right
}

@Preview(name = "Text", "Text Components")
@Composable
fun TextRendererPreview() {
  TextRenderer(
    textElement = TextElement(
      text = "Some Text",
      textStyle = TextStyle(
        textSize = 20,
        isBold = false,
      ),
      style = ElementStyle(
        id = "text"
      )
    )
  )
}
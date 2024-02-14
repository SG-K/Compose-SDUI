package com.sgk.compose_sdui.ui.widgets

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sgk.compose_sdui.di.MoshiInstance
import com.sgk.compose_sdui.helper.toColor
import com.sgk.compose_sdui.ui.theme.getFont
import com.sgk.compose_sdui.ui.theme.getFontFamily
import com.sgk.compose_sdui.ui.theme.oscineFont
import com.sgk.compose_sdui.ui.widgets.utils.semantics.addTestSemantics
import com.sgk.sduicore.adapters.SduiJsonAdapterFactory
import com.sgk.sduicore.adapters.TextJsonAdapter
import com.sgk.sduicore.adapters.constraint_layout.print
import com.sgk.sduicore.adapters.metadata.BackgroundJsonAdapter
import com.sgk.sduicore.adapters.metadata.ElementStyleJsonAdapter
import com.sgk.sduicore.adapters.metadata.LengthJsonAdapter
import com.sgk.sduicore.adapters.metadata.OrientationJsonAdapter
import com.sgk.sduicore.adapters.metadata.PaddingJsonAdapter
import com.sgk.sduicore.adapters.metadata.TextStyleJsonAdapter
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle
import com.squareup.moshi.Moshi
import com.sgk.sduicore.modal.Text as TextElement
import com.sgk.sduicore.modal.metadata.TextAlign as SduiTextAlign
import com.sgk.sduicore.modal.metadata.TextAlign.LEFT as LEFT
import com.sgk.sduicore.modal.metadata.TextAlign.RIGHT as RIGHT
import com.sgk.sduicore.modal.metadata.TextAlign.CENTER as CENTER

@Composable
fun TextRenderer(textElement: TextElement) {
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
  RIGHT -> TextAlign.Right
}

@Preview(name = "Text", "Text Components")
@Composable
fun TextRendererPreview() {

  val json_file = LocalContext.current.assets.open("preview_trail.json").bufferedReader().use {
    it.readText()
  }
  val moshi = Moshi
    .Builder()
    .add(SduiJsonAdapterFactory())
    .build()
  val element = moshi.adapter(Element::class.java).fromJson(json_file)!!

  TextRenderer(textElement = element as TextElement)

}
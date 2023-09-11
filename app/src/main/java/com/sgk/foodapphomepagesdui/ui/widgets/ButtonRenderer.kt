package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sgk.foodapphomepagesdui.helper.toColor
import com.sgk.sduicore.modal.Button as ButtonElement
import com.sgk.sduicore.modal.ButtonStyle.FILLED
import com.sgk.sduicore.modal.ButtonStyle.OUTLINED
import com.sgk.sduicore.modal.ButtonStyle.TEXT
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement

@Composable
fun ButtonRenderer(element: ButtonElement) {

  val modifier : Modifier = element.style?.asModifier() ?: Modifier

  when (element.buttonStyle) {
    FILLED -> Button(
      shape = CircleShape,
      modifier = modifier,
      colors = ButtonDefaults.buttonColors(containerColor = element.color.toColor()),
      onClick = {}
    ) {
      CompositeRenderer(element = element.text)
    }
    OUTLINED -> OutlinedButton(
      shape = CircleShape,
      border = BorderStroke(1.dp, element.color.toColor()),
      modifier = modifier,
      onClick = {}
    ) {
      CompositeRenderer(element = element.text)
    }
    TEXT -> TextButton(
      modifier = modifier,
      colors = ButtonDefaults.buttonColors(containerColor = element.color.toColor()),
      onClick = {}
    ) {
      CompositeRenderer(element = element.text)
    }
  }
}

@Preview(name = "TextButton", "Button Components")
@Composable
fun TextButtonRendererPreview() {
  ButtonRenderer(
    element = ButtonElement(
      text = Text(
        text = "Submit",
        textStyle = TextStyle(textSize = 14),
      ),
      buttonStyle = TEXT,
      color = "#5accf6",
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
}

@Preview(name = "FilledButton", "Button Components")
@Composable
fun FilledButtonRendererPreview() {
  ButtonRenderer(
    element = ButtonElement(
      text = Text(
        text = "Submit",
        textStyle = TextStyle(textSize = 14),
      ),
      buttonStyle = FILLED,
      color = "#5accf6",
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
}

@Preview(name = "OutlinedButton", "Button Components")
@Composable
fun OutlinedButtonRendererPreview() {
  ButtonRenderer(
    element = ButtonElement(
      text = Text(
        text = "Submit",
        textStyle = TextStyle(textSize = 14),
      ),
      buttonStyle = OUTLINED,
      color = "#5accf6",
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
}

//{
//  "lazyElemntId" : "7",
//  "element" : {
//  "type" : "Button",
//  "text" : "Submit",
//  "textStyle" : {
//  "textSize" : 14
//},
//  "buttonStyle" : "filled",
//  "color" : "#5accf6",
//  "style": {
//  "width" : "max",
//  "padding" : {
//  "top": 16,
//  "bottom": 8
//},
//  "id" : "button"
//}
//}
//}

//{
//  "lazyElemntId" : "7",
//  "element" : {
//  "type" : "Button",
//  "text" : {
//  "type" : "Text",
//  "text" : "Submit",
//  "textStyle" : {
//  "textSize" : 14
//}
//},
//  "buttonStyle" : "filled",
//  "color" : "#5accf6",
//  "style": {
//  "width" : "max",
//  "padding" : {
//  "top": 16,
//  "bottom": 8
//},
//  "id" : "button"
//}
//}
//}

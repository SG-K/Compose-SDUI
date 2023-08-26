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
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import com.sgk.sduicore.modal.Text as TextElement

@Composable
fun ButtonRenderer(element: ButtonElement) {
  val textElement = TextElement(
    text = element.text,
    textStyle = TextStyle(
      textColor = element.textStyle.textColor,
      textSize = element.textStyle.textSize,
      isBold = element.textStyle.isBold
    )
  )

  when (element.buttonStyle) {
    FILLED -> Button(
      shape = CircleShape,
      modifier = element.style?.asModifier() ?: Modifier,
      colors = ButtonDefaults.buttonColors(containerColor = element.color.toColor()),
      onClick = {}
    ) {
      CompositeRenderer(element = textElement)
    }
    OUTLINED -> OutlinedButton(
      shape = CircleShape,
      border = BorderStroke(1.dp, element.color.toColor()),
      modifier = element.style?.asModifier() ?: Modifier,
      onClick = {}
    ) {
      CompositeRenderer(element = textElement)
    }
    TEXT -> TextButton(
      modifier = element.style?.asModifier() ?: Modifier,
      colors = ButtonDefaults.buttonColors(containerColor = element.color.toColor()),
      onClick = {}
    ) {
      CompositeRenderer(element = textElement)
    }
  }
}

@Preview(name = "TextButton", "Button Components")
@Composable
fun TextButtonRendererPreview() {
  ButtonRenderer(
    element = ButtonElement(
      text = "Submit",
      textStyle = TextStyle(textSize = 14),
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
      text = "Submit",
      textStyle = TextStyle(textSize = 14),
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
      text = "Submit",
      textStyle = TextStyle(textSize = 14),
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

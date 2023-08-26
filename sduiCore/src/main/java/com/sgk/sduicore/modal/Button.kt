package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle


data class Button(
    val text: String,
    val textStyle: TextStyle,
    val buttonStyle: ButtonStyle,
    val color: String,
    override val style: ElementStyle? = null
) : Element(ElementType.BUTTON, style)

enum class ButtonStyle {
    FILLED,
    OUTLINED,
    TEXT
}
package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle


data class Text(
    val text: String,
    val textStyle: TextStyle,
    override val style: ElementStyle? = null,
) : Element(ElementType.TEXT, style)
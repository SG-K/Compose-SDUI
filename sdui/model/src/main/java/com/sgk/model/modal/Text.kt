package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.TextStyle


data class Text(
    val text: String,
    val textStyle: TextStyle,
    override val style: ElementStyle? = null,
) : Element(ElementType.TEXT, style)
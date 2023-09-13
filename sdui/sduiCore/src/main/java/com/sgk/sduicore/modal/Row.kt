package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle


data class Row(
    val children: List<Element>,
    override val style: ElementStyle? = null,
) : Element(ElementType.ROW, style)
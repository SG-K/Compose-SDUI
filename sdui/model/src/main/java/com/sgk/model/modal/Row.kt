package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle


data class Row(
    val children: List<Element>,
    override val style: ElementStyle? = null,
) : Element(ElementType.ROW, style)
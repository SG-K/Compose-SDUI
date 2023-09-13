package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle


data class Column(
    val children: List<com.sgk.model.modal.Element>,
    override val style: ElementStyle? = null,
) : com.sgk.model.modal.Element(com.sgk.model.modal.ElementType.COLUMN, style)
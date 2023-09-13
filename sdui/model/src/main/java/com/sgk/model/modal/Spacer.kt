package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle

data class Spacer(
    override val style: ElementStyle? = null,
): Element(ElementType.SPACER, style,)

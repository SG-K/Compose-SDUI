package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle

data class Spacer(
    override val style: ElementStyle? = null,
): Element(ElementType.SPACER, style,)

package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle

data class Box(
    override val style: ElementStyle? = null,
) : com.sgk.sduicore.modal.Element(com.sgk.sduicore.modal.ElementType.COLUMN, style)

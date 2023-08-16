package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation


data class LazyList(
    val orientation: Orientation,
    val children: List<LazyElement>,
    override val style: ElementStyle? = null,
    override val id: String
) : Element(ElementType.LAZY_LIST, style, id)
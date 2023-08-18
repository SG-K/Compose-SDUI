package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Orientation


data class LazyList(
    val orientation: Orientation,
    val children: List<LazyElement>,
    override val style: ElementStyle? = null,
) : Element(ElementType.LAZY_LIST, style,)
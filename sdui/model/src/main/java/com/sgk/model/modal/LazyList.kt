package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Orientation


data class LazyList(
    val orientation: Orientation,
    val children: List<LazyElement>,
    override val style: ElementStyle? = null,
) : Element(ElementType.LAZY_LIST, style,)
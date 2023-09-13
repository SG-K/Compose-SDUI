package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle


data class Card(
    val cardStyle: com.sgk.model.modal.CardStyle?,
    val child: com.sgk.model.modal.Element,
    override val style: ElementStyle? = null,
) : com.sgk.model.modal.Element(com.sgk.model.modal.ElementType.CARD, style)

data class CardStyle(
    val radius: Int = 0,
    val contentColor : String?,
    val elevation : Int = 0
)
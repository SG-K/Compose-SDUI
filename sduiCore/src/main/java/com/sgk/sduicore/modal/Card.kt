package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle


data class Card(
    val cardStyle: com.sgk.sduicore.modal.CardStyle?,
    val child: com.sgk.sduicore.modal.Element,
    override val style: ElementStyle? = null,
    override val id : String
) : com.sgk.sduicore.modal.Element(com.sgk.sduicore.modal.ElementType.CARD, style, id)

data class CardStyle(
    val radius: Int = 0,
    val contentColor : String?,
    val elevation : Int = 0
)
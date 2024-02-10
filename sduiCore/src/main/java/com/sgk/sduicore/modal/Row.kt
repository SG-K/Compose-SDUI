package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle


data class Row(
    val children: List<Element>,
    val alignment: Alignment = Alignment.TOP_START,
    override val style: ElementStyle? = null,
) : Element(ElementType.ROW, style)

enum class Alignment(val typeString: String){
    TOP_START("top_start"),
    TOP_CENTER("top_center"),
    TOP_END("top_end"),
    CENTER_START("center_start"),
    CENTER("center"),
    CENTER_END("center_end"),
    BOTTOM_START("bottom_start"),
    BOTTOM_CENTER("bottom_center"),
    BOTTOM_END("bottom_end"),
    CENTER_VERTICAL("center_vertical"),
    TOP("top"),
    BOTTOM("bottom"),
    CENTER_HORIZONTAL("center_horizontal");

    companion object {
        fun fromTypeString(typeString: String?) = Alignment.values().find { it.typeString == typeString }
    }
}
package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle

data class ConstraintLayout(
    val children: List<com.sgk.sduicore.modal.Element>?,
    val childernConstrainsList : List<com.sgk.sduicore.modal.ChildConstraintModel>?,
    override val style: ElementStyle? = null,
    override val id : String
) : com.sgk.sduicore.modal.Element(com.sgk.sduicore.modal.ElementType.CONSTRAINT_LAYOUT, style, id)

data class ChildConstraintModel(
    val refId : String,
    val top : com.sgk.sduicore.modal.DirectionConstraints? = null,
    val bottom : com.sgk.sduicore.modal.DirectionConstraints? = null,
    val start : com.sgk.sduicore.modal.DirectionConstraints? = null,
    val end : com.sgk.sduicore.modal.DirectionConstraints? = null,
    val width_constraint : com.sgk.sduicore.modal.ContraintHeightWidth? = null,
    val height_constraint : com.sgk.sduicore.modal.ContraintHeightWidth? = null,
)

data class DirectionConstraints(
    val contraintDirection : com.sgk.sduicore.modal.ContraintDirections,
    val constraintComposableId : String,
    val margin : Int
)

enum class ContraintDirections(val typeString: String){
    TOP("top"),
    BOTTOM("bottom"),
    START("start"),
    END("end");

    companion object {
        fun fromTypeString(typeString: String?) = com.sgk.sduicore.modal.ContraintDirections.values().find { it.typeString == typeString }
    }
}

enum class ContraintHeightWidth(val typeString: String){

    WRAP_CONTENT("wrapContent"),
    MATCH_PARENT("matchParent"),
    FILL_TO_CONSTRAINTS("fillToConstraints");
    companion object {
        fun fromTypeString(typeString: String?) = com.sgk.sduicore.modal.ContraintHeightWidth.values().find { it.typeString == typeString }
    }
}


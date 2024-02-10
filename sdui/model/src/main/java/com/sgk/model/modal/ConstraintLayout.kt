package com.sgk.model.modal

import com.sgk.model.modal.metadata.ElementStyle

data class ConstraintLayout(
    val children: List<com.sgk.model.modal.Element>?,
    val childernConstrainsList : List<com.sgk.model.modal.ChildConstraintModel>?,
    override val style: ElementStyle? = null,
) : com.sgk.model.modal.Element(com.sgk.model.modal.ElementType.CONSTRAINT_LAYOUT, style)

data class ChildConstraintModel(
    val refId : String,
    val top : com.sgk.model.modal.DirectionConstraints? = null,
    val bottom : com.sgk.model.modal.DirectionConstraints? = null,
    val start : com.sgk.model.modal.DirectionConstraints? = null,
    val end : com.sgk.model.modal.DirectionConstraints? = null,
    val width_constraint : com.sgk.model.modal.ContraintHeightWidth? = null,
    val height_constraint : com.sgk.model.modal.ContraintHeightWidth? = null,
)

data class DirectionConstraints(
    val contraintDirection : com.sgk.model.modal.ContraintDirections,
    val constraintComposableId : String,
    val margin : Int
)

enum class ContraintDirections(val typeString: String){
    TOP("top"),
    BOTTOM("bottom"),
    START("start"),
    END("end");

    companion object {
        fun fromTypeString(typeString: String?) = com.sgk.model.modal.ContraintDirections.values().find { it.typeString == typeString }
    }
}

enum class ContraintHeightWidth(val typeString: String){

    WRAP_CONTENT("wrapContent"),
    MATCH_PARENT("matchParent"),
    FILL_TO_CONSTRAINTS("fillToConstraints");
    companion object {
        fun fromTypeString(typeString: String?) = com.sgk.model.modal.ContraintHeightWidth.values().find { it.typeString == typeString }
    }
}


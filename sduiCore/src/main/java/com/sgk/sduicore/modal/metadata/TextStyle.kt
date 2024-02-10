package com.sgk.sduicore.modal.metadata


//@JsonClass(generateAdapter = true)
data class TextStyle(
    val textSize: Int,
    val isBold: Boolean? = null,
    val textColor: String? = null,
    val fontWeight : Int? = null,
    val lineHeight : Int? = null,
    val fontFamily : String? = null,
)
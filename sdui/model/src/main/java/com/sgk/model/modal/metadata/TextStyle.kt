package com.sgk.model.modal.metadata


//@JsonClass(generateAdapter = true)
data class TextStyle(
    val textSize: Int,
    val isBold: Boolean? = null,
    val textColor: String? = null
)
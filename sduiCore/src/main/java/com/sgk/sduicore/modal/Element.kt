package com.sgk.sduicore.modal

import com.sgk.sduicore.modal.metadata.ElementStyle
//import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass


//@JsonClass(generateAdapter = true)
open class Element(
//    @property:Json(name="type")
    open val type: ElementType,
//    @property:Json(name="style")
    open val style: ElementStyle?,
//    @property:Json(name="id")
//    open val id : String
)



package com.sgk.model.modal


import com.sgk.model.modal.metadata.ElementStyle


enum class ImageType(val typeString: String){
    DRAWABLE("drawable"),
    IMAGE_VECTOR("image_vector"),
    REMOTE("remote");

    companion object {
        fun fromTypeString(typeString: String?) = ImageType.values().find { it.typeString == typeString }
    }
}

data class Image(
    val url: String,
    val altText: String?,
    val imageType: ImageType,
    val tint : String?,
    override val style: ElementStyle?,
) : Element(ElementType.IMAGE, style, )


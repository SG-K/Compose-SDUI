package com.sgk.sduicore.adapters

import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.ImageType

class ImageJsonAdapter(
    private val styleJsonAdapter: JsonAdapter<ElementStyle>
) : JsonAdapter<Image>() {


    override fun fromJson(reader: JsonReader): Image {
        var url: String? = null
        var altText: String? = null
        var style: ElementStyle? = null
//        var id: String? = null
        var tint: String? = null
        var imageType: ImageType? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(com.sgk.sduicore.adapters.AdapterConstants.KEY_OPTIONS_IMAGE)) {
                0 -> {
                    url = reader.nextString()
                }
                1 -> {
                    altText = reader.nextString()
                }
                2 -> {
                    val decodeDirection = reader.readJsonValue().toString()
                    imageType = ImageType.fromTypeString(decodeDirection)
                }
                3 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
//                4 -> {
//                    id = reader.nextString()
//                }
                4 -> {
                    tint = reader.nextString()
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (url == null) {
            throw IllegalArgumentException("Required property url is missing")
        }

        return Image(
            url = url,
            altText = altText,
            style = style,
            imageType = imageType ?: ImageType.REMOTE,
            tint = tint,
//            id = id ?: System.currentTimeMillis().toString()
        )
    }

    override fun toJson(writer: JsonWriter, value: Image?) {

        if (value == null) {
            writer.nullValue()
            return
        }
        writer.beginObject()

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_TYPE)
        writer.value(value.type.typeString)

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_URL)
        writer.value(value.url)

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_ALT_TEXT)
        writer.value(value.altText)

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_IMAGE_TYPE)
        writer.value(value.imageType.typeString)

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_STYLE)
        styleJsonAdapter.toJson(writer, value.style)

//        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_ID)
//        writer.value(value.id)

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_TINT)
        writer.value(value.tint)

        writer.endObject()
    }
}
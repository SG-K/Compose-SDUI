package com.sgk.sduicore.modal.adapters.metadata

import com.sgk.sduicore.modal.CardStyle
import com.sgk.sduicore.modal.adapters.AdapterConstants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class CardStyleJsonAdapter : JsonAdapter<com.sgk.sduicore.modal.CardStyle>() {
    override fun fromJson(reader: JsonReader): com.sgk.sduicore.modal.CardStyle? {
        var radius: Int = 0
        var contentColor : String? = null
        var elevation : Int = 0

        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(AdapterConstants.KEY_OPTIONS_CARD_STYLE)) {
                0 -> {
                    radius = reader.nextInt()
                }

                1 -> {
                    contentColor = reader.nextString()
                }

                2 -> {
                    elevation = reader.nextInt()
                }

                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        return com.sgk.sduicore.modal.CardStyle(
            radius, contentColor, elevation
        )
    }

    override fun toJson(writer: JsonWriter, value: com.sgk.sduicore.modal.CardStyle?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(AdapterConstants.KEY_RADIUS)
            writer.value(value.radius)

            writer.name(AdapterConstants.KEY_CONTENT_COLOR)
            writer.value(value.contentColor)

            writer.name(AdapterConstants.KEY_ELEVATION)
            writer.value(value.elevation)

            writer.endObject()
        }
    }
}
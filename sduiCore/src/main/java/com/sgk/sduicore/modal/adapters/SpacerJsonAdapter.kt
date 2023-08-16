package com.sgk.sduicore.modal.adapters

import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Spacer
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class SpacerJsonAdapter(
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
) : JsonAdapter<Spacer>() {

    override fun fromJson(reader: JsonReader): Spacer? {
        var style: ElementStyle? = null
        var id: String? = null
        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(AdapterConstants.KEY_OPTIONS_SPACER)) {
                1 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
                2 -> {
                    id = reader.nextString()
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        return Spacer(
            style = style,
            id = id ?: System.currentTimeMillis().toString()
        )

    }

    override fun toJson(writer: JsonWriter, value: Spacer?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(AdapterConstants.KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(AdapterConstants.KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

            writer.name(AdapterConstants.KEY_ID)
            writer.value( value.id)


            writer.endObject()
        }
    }

}
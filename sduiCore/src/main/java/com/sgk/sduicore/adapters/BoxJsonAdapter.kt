package com.sgk.sduicore.adapters

import com.sgk.sduicore.modal.Box
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class BoxJsonAdapter(
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
): JsonAdapter<Box>() {
    override fun fromJson(reader: JsonReader): Box? {
        var style: ElementStyle? = null
        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(com.sgk.sduicore.adapters.AdapterConstants.KEY_OPTIONS_SPACER)) {
                1 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        return Box(
            style = style,
        )
    }

    override fun toJson(writer: JsonWriter, value: Box?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

            writer.endObject()
        }
    }
}
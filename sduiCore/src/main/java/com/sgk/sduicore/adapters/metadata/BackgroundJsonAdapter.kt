package com.sgk.sduicore.adapters.metadata

import com.sgk.sduicore.modal.metadata.ElementBackground
import com.sgk.sduicore.modal.metadata.Orientation
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class BackgroundJsonAdapter(
    private val orientationJsonAdapter: JsonAdapter<Orientation>,
) : JsonAdapter<ElementBackground>() {

    @FromJson
    override fun fromJson(reader: JsonReader): ElementBackground? {
        if (reader.peek() == JsonReader.Token.NULL) {
            reader.skipValue()
            return null
        }

        var orientation: Orientation? = null
        val colors: MutableList<String> = mutableListOf()

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(com.sgk.sduicore.adapters.AdapterConstants.KEY_OPTIONS_BACKGROUND)) {
                0 -> {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        val element = reader.nextString()
                        colors.add(element)
                    }
                    reader.endArray()
                }
                1 -> {
                    orientation = orientationJsonAdapter.fromJson(reader)
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (colors.isEmpty()){
            throw Exception("Invalid list of colors")
        }

        return ElementBackground(
            colors = colors,
            orientation = orientation
        )
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: ElementBackground?) {
        writer.beginObject()

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_COLORS)
        writer.beginArray()
        value?.colors?.forEach { color ->
            writer.value(color)
        }
        writer.endArray()

        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_ORIENTATION)
        orientationJsonAdapter.toJson(writer, value?.orientation)

        writer.endObject()
    }
}
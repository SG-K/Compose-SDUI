package com.sgk.model.adapters.metadata

import com.sgk.model.adapters.AdapterConstants
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Length
import com.sgk.model.modal.metadata.Padding
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class ElementStyleJsonAdapter constructor(
    private val lengthJsonAdapter: JsonAdapter<Length>,
    private val paddingJsonAdapter: JsonAdapter<Padding>
) : JsonAdapter<ElementStyle>() {

    companion object {
        private const val KEY_WIDTH = "width"
        private const val KEY_HEIGHT = "height"
        private const val KEY_PADDING = "padding"
        private const val KEY_BACKGROUND = "background"
        private val KEY_OPTIONS = JsonReader.Options.of(KEY_WIDTH, KEY_HEIGHT, KEY_PADDING, KEY_BACKGROUND, AdapterConstants.KEY_ID)
    }

    override fun fromJson(reader: JsonReader): ElementStyle? {
        var width: Length? = null
        var height: Length? = null
        var padding: Padding? = null
        var background : String? = null
        var id : String? = null

        if (reader.peek() == JsonReader.Token.NULL) {
            reader.skipValue()
            return null
        }

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(KEY_OPTIONS)) {
                0 -> {
                    width = lengthJsonAdapter.fromJson(reader)
                }
                1 -> {
                    height = lengthJsonAdapter.fromJson(reader)
                }
                2 -> {
                    padding = paddingJsonAdapter.fromJson(reader)
                }
                3 -> {
                    background = reader.nextString()
                }
                4 -> {
                    id = reader.nextString()
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        return ElementStyle(width, height, padding, background, id)
    }

    override fun toJson(writer: JsonWriter, value: ElementStyle?) {
        if (value == null) {
            writer.nullValue()
            return
        }

        writer.beginObject()

        writer.name(KEY_WIDTH)
        lengthJsonAdapter.toJson(writer, value.width)

        writer.name(KEY_HEIGHT)
        lengthJsonAdapter.toJson(writer, value.height)

        writer.name(KEY_PADDING)
        paddingJsonAdapter.toJson(writer, value.padding)

        writer.name(KEY_BACKGROUND)
        writer.value(value.background)

        writer.name(AdapterConstants.KEY_ID)
        writer.value(value.id)

        writer.endObject()
    }

}
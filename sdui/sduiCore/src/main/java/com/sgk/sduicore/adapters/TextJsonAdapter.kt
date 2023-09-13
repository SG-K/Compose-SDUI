package com.sgk.sduicore.adapters

import com.sgk.sduicore.modal.ElementType
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.TextStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class TextJsonAdapter constructor(
    private val textStyleJsonAdapter: JsonAdapter<TextStyle>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
) : JsonAdapter<Text>() {

    companion object {
//        private const val KEY_ID = "id"
        private const val KEY_TYPE = "type"
        private const val KEY_TEXT = "text"
        private const val KEY_TEXT_STYLE = "textStyle"
        private const val KEY_STYLE = "style"
        private val KEY_OPTIONS = JsonReader.Options.of(
            KEY_TEXT,
            KEY_TEXT_STYLE,
            KEY_STYLE,
//            KEY_ID
        )
    }

    override fun fromJson(reader: JsonReader): Text {
        var text: String? = null
        var textStyle: TextStyle? = null
        var style: ElementStyle? = null
        var id : String? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(KEY_OPTIONS)) {
                0 -> {
                    text = reader.nextString()
                }
                1 -> {
                    textStyle = textStyleJsonAdapter.fromJson(reader)
                }
                2 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
//                3 -> {
//                    id = reader.nextString()
//                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()

        if (text == null) {
            throw IllegalArgumentException("Required property text is missing")
        }

        if (textStyle == null) {
            throw IllegalArgumentException("Required property textStyle is missing")
        }

        return Text(
            text = text,
            textStyle = textStyle,
            style = style,
//            id = id ?: System.currentTimeMillis().toString()
        )
    }

    override fun toJson(writer: JsonWriter, value: Text?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject() // {
            writer.name(KEY_TYPE) // "type":
            writer.value(ElementType.TEXT.typeString) // "text",

            writer.name(KEY_TEXT) // "text":
            writer.value(value.text)

            writer.name(KEY_TEXT_STYLE) // "textStyle":
            textStyleJsonAdapter.toJson(writer, value.textStyle)

            writer.name(KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

//            writer.name(KEY_ID) // "text":
//            writer.value(value.id)

            writer.endObject() // }
        }
    }


}
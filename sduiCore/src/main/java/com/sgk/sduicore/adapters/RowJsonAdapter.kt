package com.sgk.sduicore.adapters

import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.adapters.ElementJsonAdapter
import com.sgk.sduicore.adapters.constraint_layout.print
import com.sgk.sduicore.modal.Alignment
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class RowJsonAdapter(
    private val elementJsonAdapter: JsonAdapter<Element>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
) : JsonAdapter<Row>() {

    companion object {
        private const val KEY_ID = "id"
        private const val KEY_TYPE = "type"
        private const val KEY_CHILDREN = "children"
        private const val KEY_STYLE = "style"
        private const val KEY_ALIGNMENT = "alignment"
        private val KEY_OPTIONS = JsonReader.Options.of(
            KEY_CHILDREN,
            KEY_STYLE,
            KEY_ALIGNMENT,
//            KEY_ID
        )
    }

    override fun fromJson(reader: JsonReader): Row {
        var children: MutableList<Element>? = null
        var style: ElementStyle? = null
        var alignment : Alignment? = null
        var id : String? = null
        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(KEY_OPTIONS)) {
                0 -> {
                    if (children == null) children = mutableListOf()
                    reader.beginArray()
                    while (reader.hasNext()) {
                        val jsonValueMap = reader.readJsonValue() as Map<*, *>
                        val element = elementJsonAdapter.fromJsonValue(jsonValueMap) ?: break
                        children.add(element)
                    }
                    reader.endArray()
                }
                1 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
                2 -> {
                    val typeString = reader.nextString()
                    alignment = Alignment.fromTypeString(typeString)
                }
//                2 -> {
//                    id = reader.nextString()
//                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (children == null) {
            throw IllegalArgumentException("Required property children is missing")
        }

        return Row(
            children = children.toList(),
            style = style,
            alignment = alignment ?: Alignment.TOP_START
//            id = id ?: System.currentTimeMillis().toString()
        )
    }

    override fun toJson(writer: JsonWriter, value: Row?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(KEY_CHILDREN)
            writer.beginArray()
            value.children.forEach { element ->
                elementJsonAdapter.toJson(writer, element)
            }
            writer.endArray()

            writer.name(KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

//            writer.name(KEY_ID)
//            writer.value( value.id)

            writer.endObject()
        }
    }
}
package com.sgk.sduicore.modal.adapters

import com.sgk.sduicore.modal.Card
import com.sgk.sduicore.modal.CardStyle
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class CardJsonAdapter(
    private val elementJsonAdapter: JsonAdapter<Element>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
    private val cardStyleJsonAdapter: JsonAdapter<com.sgk.sduicore.modal.CardStyle>,
) : JsonAdapter<com.sgk.sduicore.modal.Card>() {

    companion object {
        private const val KEY_TYPE = "type"
        private const val KEY_ID = "id"
        private const val KEY_CARD_STYLE = "cardStyle"
        private const val KEY_CHILD = "child"
        private const val KEY_STYLE = "style"
        private val KEY_OPTIONS = JsonReader.Options.of(
            KEY_CHILD,
            KEY_CARD_STYLE,
            KEY_STYLE,
            KEY_ID
        )
    }

    override fun fromJson(reader: JsonReader): com.sgk.sduicore.modal.Card {
        var child: Element? = null
        var cardStyle : com.sgk.sduicore.modal.CardStyle? = null
        var style: ElementStyle? = null
        var id : String? = null
        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(KEY_OPTIONS)) {
                0 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
                    child = elementJsonAdapter.fromJsonValue(jsonValueMap) ?: break
                }
                1 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
                    cardStyle = cardStyleJsonAdapter.fromJsonValue(jsonValueMap) ?: break
                }
                2 -> {
                    style = styleJsonAdapter.fromJson(reader)
                }
                3 -> {
                    id = reader.nextString()
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (child == null) {
            throw IllegalArgumentException("Required property child is missing")
        }

        return com.sgk.sduicore.modal.Card(
            cardStyle = cardStyle,
            child = child,
            style = style,
            id = id ?: System.currentTimeMillis().toString()
        )
    }

    override fun toJson(writer: JsonWriter, value: com.sgk.sduicore.modal.Card?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(KEY_CARD_STYLE)
            cardStyleJsonAdapter.toJson(writer, value.cardStyle)

            writer.name(KEY_CHILD)
            elementJsonAdapter.toJson(writer, value.child)

            writer.name(KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

            writer.name(KEY_ID)
            writer.value(value.id)

            writer.endObject()
        }
    }
}
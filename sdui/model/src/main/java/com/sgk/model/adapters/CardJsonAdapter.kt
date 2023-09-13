package com.sgk.model.adapters

import com.sgk.model.modal.Element
import com.sgk.model.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class CardJsonAdapter(
    private val elementJsonAdapter: JsonAdapter<Element>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
    private val cardStyleJsonAdapter: JsonAdapter<com.sgk.model.modal.CardStyle>,
) : JsonAdapter<com.sgk.model.modal.Card>() {

    companion object {
        private const val KEY_TYPE = "type"
        private const val KEY_ID = "id"
        private const val KEY_CARD_STYLE = "cardStyle"
        private const val KEY_CHILD = "child"
        private const val KEY_STYLE = "style"
        private val KEY_OPTIONS = JsonReader.Options.of(
            com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_CHILD,
            com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_CARD_STYLE,
            com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_STYLE,
//            com.sgk.sduicore.adapters.CardJsonAdapter.Companion.KEY_ID
        )
    }

    override fun fromJson(reader: JsonReader): com.sgk.model.modal.Card {
        var child: Element? = null
        var cardStyle : com.sgk.model.modal.CardStyle? = null
        var style: ElementStyle? = null
        var id : String? = null
        reader.beginObject()

        while (reader.hasNext()) {

            when (reader.selectName(com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_OPTIONS)) {
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

        return com.sgk.model.modal.Card(
            cardStyle = cardStyle,
            child = child,
            style = style,
        )
    }

    override fun toJson(writer: JsonWriter, value: com.sgk.model.modal.Card?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_CARD_STYLE)
            cardStyleJsonAdapter.toJson(writer, value.cardStyle)

            writer.name(com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_CHILD)
            elementJsonAdapter.toJson(writer, value.child)

            writer.name(com.sgk.model.adapters.CardJsonAdapter.Companion.KEY_STYLE)
            styleJsonAdapter.toJson(writer, value.style)

//            writer.name(com.sgk.sduicore.adapters.CardJsonAdapter.Companion.KEY_ID)
//            writer.value(value.id)

            writer.endObject()
        }
    }
}
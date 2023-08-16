package com.sgk.sduicore.modal.adapters

import com.sgk.sduicore.modal.Card
import com.sgk.sduicore.modal.Column
import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.ElementType
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Spacer
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.adapters.constraint_layout.print
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class ElementJsonAdapter(
    private val constraintJsonAdapter: JsonAdapter<ConstraintLayout>,
    private val columnJsonAdapter: JsonAdapter<Column>,
    private val textJsonAdapter: JsonAdapter<Text>,
    private val rowJsonAdapter: JsonAdapter<Row>,
    private val imageJsonAdapter: JsonAdapter<Image>,
    private val cardJsonAdapter: JsonAdapter<Card>,
    private val lazyListJsonAdapter: JsonAdapter<LazyList>,
    private val spacerJsonAdapter: JsonAdapter<Spacer>,
) : JsonAdapter<Element>() {

    companion object {
        private const val KEY_TYPE = "type"
    }

    override fun fromJson(reader: JsonReader): Element? {
        var element: Element? = null
        while (reader.hasNext()) {
            val jsonValueMap = reader.readJsonValue() as Map<*, *>
            "sample_key_options root json - $jsonValueMap".print()
            val typeString = jsonValueMap[KEY_TYPE] as String

            when (ElementType.fromTypeString(typeString)) {
                ElementType.CONSTRAINT_LAYOUT-> {
                    element = constraintJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.COLUMN-> {
                    element = columnJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.ROW-> {
                    element = rowJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.TEXT-> {
                    element = textJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.IMAGE-> {
                    element = imageJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.CARD-> {
                    element = cardJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.LAZY_LIST-> {
                    element = lazyListJsonAdapter.fromJsonValue(jsonValueMap)
                }
                ElementType.SPACER-> {
                    element = spacerJsonAdapter.fromJsonValue(jsonValueMap)
                }
                null -> {
                    throw IllegalArgumentException("Illegal type: $typeString found. Refer to Loki spec")
                }
                else -> {
                    throw IllegalArgumentException("Illegal type: $typeString found. Refer to Loki spec")
                }
            }
        }

        return element
    }

    override fun toJson(writer: JsonWriter, value: Element?) {
        if (value == null) {
            writer.nullValue()
        } else {
            when (value.type) {
                ElementType.CONSTRAINT_LAYOUT-> {
                    constraintJsonAdapter.toJson(writer, value as com.sgk.sduicore.modal.ConstraintLayout)
                }
                else -> {}
            }
        }
    }
}
package com.sgk.model.adapters

import com.sgk.model.modal.Card
import com.sgk.model.modal.Column
import com.sgk.model.modal.ConstraintLayout
import com.sgk.model.modal.Element
import com.sgk.model.modal.ElementType
import com.sgk.model.modal.Image
import com.sgk.model.modal.LazyList
import com.sgk.model.modal.Row
import com.sgk.model.modal.Spacer
import com.sgk.model.modal.Text
import com.sgk.model.adapters.constraint_layout.print
import com.sgk.model.modal.Button
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
    private val buttonJsonAdapter: JsonAdapter<Button>,
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
                ElementType.BUTTON-> {
                    element = buttonJsonAdapter.fromJsonValue(jsonValueMap)
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
                    constraintJsonAdapter.toJson(writer, value as com.sgk.model.modal.ConstraintLayout)
                }
                else -> {}
            }
        }
    }
}
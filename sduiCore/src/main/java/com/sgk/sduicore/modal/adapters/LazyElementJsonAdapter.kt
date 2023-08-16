package dev.aungkyawpaing.loki.adapter

import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.LazyElement
import com.sgk.sduicore.modal.adapters.AdapterConstants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.lang.IllegalArgumentException

class LazyElementJsonAdapter(
    private val elementJsonAdapter: JsonAdapter<Element>
) : JsonAdapter<LazyElement>() {

    override fun fromJson(reader: JsonReader): LazyElement {
        var id: String? = null
        var element: Element? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(AdapterConstants.KEY_OPTIONS_LAZY_ELEMENT)) {
                0 -> {
                    id = reader.nextString()
                }
                1 -> {
                    element = elementJsonAdapter.fromJson(reader)
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }
        reader.endObject()

        if (id == null) {
            throw IllegalArgumentException("Required property 'id' is missing")
        }

        if (element == null) {
            throw IllegalArgumentException("Required property 'element' is missing")
        }

        return LazyElement(
            id = id,
            element = element
        )
    }

    override fun toJson(writer: JsonWriter, value: LazyElement?) {
        writer.beginObject()

        writer.name(AdapterConstants.KEY_ID)
        writer.value(value!!.id)

        writer.name(AdapterConstants.KEY_ELEMENT)
        elementJsonAdapter.toJson(writer, value.element)

        writer.endObject()
    }
}
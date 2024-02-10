package dev.aungkyawpaing.loki.adapter

import com.sgk.model.modal.Element
import com.sgk.model.modal.LazyElement
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
            when (reader.selectName(com.sgk.model.adapters.AdapterConstants.KEY_OPTIONS_LAZY_ELEMENT)) {
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
            lazyElemntId = id,
            element = element
        )
    }

    override fun toJson(writer: JsonWriter, value: LazyElement?) {
        writer.beginObject()

        writer.name(com.sgk.model.adapters.AdapterConstants.KEY_ID)
        writer.value(value!!.lazyElemntId)

        writer.name(com.sgk.model.adapters.AdapterConstants.KEY_ELEMENT)
        elementJsonAdapter.toJson(writer, value.element)

        writer.endObject()
    }
}
package dev.aungkyawpaing.loki.adapter

import com.sgk.model.modal.LazyElement
import com.sgk.model.modal.LazyList
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Orientation
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.lang.IllegalArgumentException

class LazyListJsonAdapter(
    private val orientationJsonAdapter: JsonAdapter<Orientation>,
    private val lazyElementJsonAdapter: JsonAdapter<LazyElement>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
) : JsonAdapter<LazyList>() {

    override fun fromJson(reader: JsonReader): LazyList {
        var orientation: Orientation? = null
        val children: MutableList<LazyElement> = mutableListOf()
        var style: ElementStyle? = null
//        var id : String? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(com.sgk.model.adapters.AdapterConstants.KEY_OPTIONS_LAZY_LIST)) {
                0 -> {
                    orientation = orientationJsonAdapter.fromJson(reader)
                }
                1 -> {
                    reader.beginArray()
                    while (reader.hasNext()) {
                        val element = lazyElementJsonAdapter.fromJson(reader) ?: break
                        children.add(element)
                    }
                    reader.endArray()
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

        if (orientation == null) {
            throw IllegalArgumentException("Required property 'orientation' is missing")
        }

        return LazyList(
            orientation = orientation,
            children = children,
            style = style,
//            id = id ?: System.currentTimeMillis().toString()
        )
    }

    override fun toJson(writer: JsonWriter, value: LazyList?) {
        writer.beginObject()

        writer.name(com.sgk.model.adapters.AdapterConstants.KEY_TYPE)
        writer.value(value!!.type.typeString)

        writer.name(com.sgk.model.adapters.AdapterConstants.KEY_ORIENTATION)
        orientationJsonAdapter.toJson(writer, value.orientation)

        writer.name(com.sgk.model.adapters.AdapterConstants.KEY_CHILDREN)
        writer.beginArray()
        value.children.forEach { lazyElement ->
            lazyElementJsonAdapter.toJson(writer, lazyElement)
        }
        writer.endArray()

//        writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_ID)
//        writer.value(value.id)

        writer.endObject()
    }
}
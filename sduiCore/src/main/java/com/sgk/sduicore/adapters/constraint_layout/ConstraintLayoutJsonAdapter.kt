package com.sgk.sduicore.adapters.constraint_layout

import android.util.Log
import com.sgk.sduicore.modal.ChildConstraintModel
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.adapters.ElementJsonAdapter
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

fun Any?.print(){
    Log.v("sdjkvbsvjd", "$this")
}

class ConstraintLayoutJsonAdapter (
    private val elementJsonAdapter: JsonAdapter<Element>,
    private val styleJsonAdapter: JsonAdapter<ElementStyle>,
    private val childConstraintModelJsonAdapter : JsonAdapter<com.sgk.sduicore.modal.ChildConstraintModel>
): JsonAdapter<ConstraintLayout>() {

    companion object {
        private const val KEY_TYPE = "type"
        private const val KEY_CHILDREN = "children"
        private const val KEY_CHILDREN_CONSTRAINTS = "childernConstrainsList"
        private const val KEY_STYLE = "style"
        private const val KEY_ID = "id"
        private val KEY_OPTIONS = JsonReader.Options.of(
            KEY_CHILDREN,
            KEY_CHILDREN_CONSTRAINTS,
            KEY_STYLE,
            KEY_ID
        )
    }

    override fun fromJson(reader: JsonReader): com.sgk.sduicore.modal.ConstraintLayout {
        var children: MutableList<Element>? = null
        var childernConstrainsList : MutableList<com.sgk.sduicore.modal.ChildConstraintModel>? = null
        var style: ElementStyle? = null
        var id : String? = null

        reader.beginObject()
        "sample_key_options constraint layout from json".print()
        "sample_key_options reader nextName - ${reader.path}".print()
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
                    if (childernConstrainsList == null) childernConstrainsList = mutableListOf()
                    reader.beginArray()
                    while (reader.hasNext()) {
                        val jsonValueMap = reader.readJsonValue() as Map<*, *>
                        val element = childConstraintModelJsonAdapter.fromJsonValue(jsonValueMap) ?: break
                        childernConstrainsList.add(element)
                    }
                    reader.endArray()
                }
//                3 -> {
//                    id = reader.nextString()
//                }
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

        if (children == null) {
            throw IllegalArgumentException("Required property children is missing")
        }

        if (childernConstrainsList == null) {
            throw IllegalArgumentException("Required property children constraints is missing")
        }

        if (childernConstrainsList.size != children.size) {
            throw IllegalArgumentException("childern list and its contraints are not matching")
        }

        return com.sgk.sduicore.modal.ConstraintLayout(
            children = children.toList(),
            childernConstrainsList = childernConstrainsList.toList(),
            style = style,
//            id = id ?: System.currentTimeMillis().toString()
        )


    }

    override fun toJson(writer: JsonWriter, value: com.sgk.sduicore.modal.ConstraintLayout?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(KEY_TYPE)
            writer.value(value.type.typeString)

            writer.name(KEY_CHILDREN)
            writer.beginArray()
            value.children?.forEach { element ->
                elementJsonAdapter.toJson(writer, element)
            }
            writer.endArray()

            writer.name(KEY_CHILDREN_CONSTRAINTS)
            writer.beginArray()
            value.childernConstrainsList?.forEach { element ->
                childConstraintModelJsonAdapter.toJson(writer, element)
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
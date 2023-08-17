package com.sgk.sduicore.adapters.constraint_layout

import com.sgk.sduicore.modal.ChildConstraintModel
import com.sgk.sduicore.modal.ContraintHeightWidth
import com.sgk.sduicore.modal.DirectionConstraints
import com.sgk.sduicore.adapters.AdapterConstants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

class ChildConstraintModelJsonAdapter (
    private val directionConstraintsJsonAdapter: JsonAdapter<com.sgk.sduicore.modal.DirectionConstraints>
):  JsonAdapter<com.sgk.sduicore.modal.ChildConstraintModel>() {

    override fun fromJson(reader: JsonReader): com.sgk.sduicore.modal.ChildConstraintModel? {

        var refId : String? = null
        var top : DirectionConstraints? = null
        var bottom : DirectionConstraints? = null
        var start : DirectionConstraints? = null
        var end : DirectionConstraints? = null
        var width : ContraintHeightWidth? = null
        var height : ContraintHeightWidth? = null

        reader.beginObject()
        while (reader.hasNext()) {
            val temData = reader.selectName(com.sgk.sduicore.adapters.AdapterConstants.KEY_OPTIONS_CHILD_CONTRAINT_SET)
            when (temData) {
                0 -> {
                    refId = reader.nextString()
                }
                1 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
//                    val element = childConstraintModelJsonAdapter.fromJsonValue(jsonValueMap) ?: break
                    top = directionConstraintsJsonAdapter.fromJsonValue(jsonValueMap)
                }
                2 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
                    bottom = directionConstraintsJsonAdapter.fromJsonValue(jsonValueMap)
                }
                3 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
                    start = directionConstraintsJsonAdapter.fromJsonValue(jsonValueMap)
                }
                4 -> {
                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
                    end = directionConstraintsJsonAdapter.fromJsonValue(jsonValueMap)
                }
                5 -> {
                    val _width = reader.readJsonValue().toString()
                    width = ContraintHeightWidth.fromTypeString(_width)
                }
                6 -> {
                    val _height = reader.readJsonValue().toString()
                    height = ContraintHeightWidth.fromTypeString(_height)
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (refId == null) {
            throw IllegalArgumentException("Required a valid reference id")
        }

        return com.sgk.sduicore.modal.ChildConstraintModel(
            refId, top, bottom, start, end, width, height
        )

    }

    override fun toJson(writer: JsonWriter, value: com.sgk.sduicore.modal.ChildConstraintModel?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_REF_ID)
            writer.value(value.refId)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_TOP)
            directionConstraintsJsonAdapter.toJson(writer, value.top)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_BOTTOM)
            directionConstraintsJsonAdapter.toJson(writer, value.bottom)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_START)
            directionConstraintsJsonAdapter.toJson(writer, value.start)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_END)
            directionConstraintsJsonAdapter.toJson(writer, value.end)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_WIDTH_CONSTRAINT)
            writer.value(value.width_constraint?.typeString)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_HEIGHT_CONSTRAINT)
            writer.value(value.height_constraint?.typeString)

            writer.endObject()
        }
    }
}
package com.sgk.sduicore.adapters.constraint_layout

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson

class DirectionConstraintsJsonAdapter :  JsonAdapter<com.sgk.sduicore.modal.DirectionConstraints>() {

    @FromJson
    override fun fromJson(reader: JsonReader): com.sgk.sduicore.modal.DirectionConstraints? {
        var contraintDirection : com.sgk.sduicore.modal.ContraintDirections? = null
        var constraintComposableId : String? = null
        var margin : Int? = null


//        if (reader.peek() == JsonReader.Token.NULL) {
//            reader.skipValue()
//            return null
//        }

        reader.beginObject()

        while (reader.hasNext()) {
            when (reader.selectName(com.sgk.sduicore.adapters.AdapterConstants.KEY_OPTIONS_DIRECTION_CONSTRAINT)) {
                0 -> {
//                    val jsonValueMap = reader.readJsonValue() as Map<*, *>
//                    val typeString = jsonValueMap[KEY_CONSTRAINT_DIRECTION] as String
                    val decodeDirection = reader.readJsonValue().toString()
                    contraintDirection = com.sgk.sduicore.modal.ContraintDirections.fromTypeString(decodeDirection)
                }
                1 -> {
                    constraintComposableId = reader.nextString()
                }
                2 -> {
                    margin = reader.nextInt()
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (contraintDirection == null) {
            throw IllegalArgumentException("Required a valid constraint direction")
        }

        if (constraintComposableId == null) {
            throw IllegalArgumentException("Required a valid composable id to create constraints")
        }

        return com.sgk.sduicore.modal.DirectionConstraints(
            contraintDirection = contraintDirection,
            constraintComposableId = constraintComposableId,
            margin = margin ?: 0
        )

    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: com.sgk.sduicore.modal.DirectionConstraints?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_CONSTRAINT_DIRECTION)
            writer.value(value.contraintDirection.typeString)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_CONSTRAINT_COMPOSABLE_ID)
            writer.value(value.constraintComposableId)

            writer.name(com.sgk.sduicore.adapters.AdapterConstants.KEY_MARGIN)
            writer.value(value.margin)

            writer.endObject()
        }
    }


}
package com.sgk.model.adapters.metadata

import com.sgk.model.modal.metadata.Orientation
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.lang.IllegalArgumentException

class OrientationJsonAdapter : JsonAdapter<Orientation>() {

    override fun fromJson(reader: JsonReader): Orientation {
        return when (reader.nextString()) {
            "horizontal" -> Orientation.HORIZONTAL
            "vertical" -> Orientation.VERTICAL
            else -> throw IllegalArgumentException("Orientation must either be 'vertical' or 'horizontal'")
        }
    }

    override fun toJson(writer: JsonWriter, value: Orientation?) {
        when (value) {
            Orientation.HORIZONTAL -> {
                writer.value("horizontal")
            }
            Orientation.VERTICAL -> {
                writer.value("vertical")
            }
            null -> {
                throw IllegalStateException("Orientation cannot be null")
            }
        }
    }

}
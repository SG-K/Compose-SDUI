package com.sgk.sduicore.modal.adapters.metadata

import com.sgk.sduicore.modal.metadata.Length
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.lang.IllegalArgumentException
import kotlin.math.roundToInt

class LengthJsonAdapter : JsonAdapter<Length>() {

    @FromJson
    override fun fromJson(reader: JsonReader): Length? {
        if (reader.peek() == JsonReader.Token.NULL) {
            reader.skipValue()
            return null
        }

        val value = reader.nextString()

        if (value.toDoubleOrNull() != null) {
            return Length.Number(value.toDoubleOrNull()!!.roundToInt())
        }

        if (value == "max") {
            return Length.Max
        }

        throw IllegalArgumentException("Unknown length : ${value}. It must either be numeral or 'max'")
    }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Length?) {
        when (value) {
            is Length.Max -> {
                writer.value("max")
            }
            is Length.Number -> {
                writer.value(value.value)
            }
            null -> writer.nullValue()
        }
    }
}
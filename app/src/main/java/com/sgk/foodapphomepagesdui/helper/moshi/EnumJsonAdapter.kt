package com.sgk.foodapphomepagesdui.helper.moshi

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import java.io.IOException

class EnumJsonAdapter<T : Enum<T>>(private val enumClass: Class<T>) {

    @FromJson
    fun fromJson(reader: JsonReader): T? {
        return try {
            enumClass.enumConstants?.firstOrNull { it.name == reader.nextString() }
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: T?) {
        writer.value(value?.name)
    }
}
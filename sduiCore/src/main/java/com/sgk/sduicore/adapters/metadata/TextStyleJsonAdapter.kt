package com.sgk.sduicore.adapters.metadata

import com.sgk.sduicore.adapters.constraint_layout.print
import com.sgk.sduicore.modal.metadata.TextAlign
import com.sgk.sduicore.modal.metadata.TextStyle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.io.IOException

class TextStyleJsonAdapter : JsonAdapter<TextStyle>() {

    companion object {
        private const val KEY_TEXT_SIZE = "textSize"
        private const val KEY_IS_BOLD = "isBold"
        private const val KEY_TEXT_COLOR = "textColor"
        private const val KEY_FONT_WEIGHT = "fontWeight"
        private const val KEY_LINE_HEIGHT = "lineHeight"
        private const val KEY_FONT_FAMILY = "fontFamily"
        private const val KEY_ALIGN = "align"
        private val KEY_OPTIONS = JsonReader.Options.of(
            KEY_TEXT_SIZE,
            KEY_IS_BOLD,
            KEY_TEXT_COLOR,
            KEY_FONT_WEIGHT,
            KEY_LINE_HEIGHT,
            KEY_FONT_FAMILY,
            KEY_ALIGN
        )
    }

    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): TextStyle {
        var textSize: Int? = null
        var isBold: Boolean? = null
        var textColor: String? = null
        var fontWeight: Int? = null
        var lineHeight: Int? = null
        var fontFamily: String? = null
        var align : TextAlign? = null

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.selectName(KEY_OPTIONS)) {
                0 -> {
                    textSize = reader.nextInt()
                }
                1 -> {
                    isBold = reader.nextBoolean()
                }
                2 -> {
                    textColor = reader.nextString()
                }
                3 -> {
                    fontWeight = reader.nextInt()
                }
                4 -> {
                    lineHeight = reader.nextInt()
                }
                5 -> {
                    fontFamily = reader.nextString()
                }
                6 -> {
                    val sam = reader.nextString()
                    "sdvfdfv json data = $sam".print()
                    align = when(sam){
                        "center" -> TextAlign.CENTER
                        "right" -> TextAlign.RIGHT
                        else -> TextAlign.LEFT
                     }
                }
                else -> {
                    reader.skipName()
                    reader.skipValue()
                }
            }
        }

        reader.endObject()

        if (textSize == null) {
            throw IllegalArgumentException("Required property textStyle is missing")
        }

        return TextStyle(
            textSize = textSize,
            isBold = isBold,
            textColor = textColor,
            lineHeight = lineHeight,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            align = align,
        )
    }

    @Throws(IOException::class)
    override fun toJson(writer: JsonWriter, value: TextStyle?) {
        if (value == null) {
            writer.nullValue()
        } else {
            writer.beginObject()
            writer.name(KEY_TEXT_SIZE)
            writer.value(value.textSize)

            writer.name(KEY_IS_BOLD)
            writer.value(value.isBold)

            writer.name(KEY_TEXT_COLOR)
            writer.value(value.textColor)

            writer.name(KEY_FONT_WEIGHT)
            writer.value(value.fontWeight)

            writer.name(KEY_LINE_HEIGHT)
            writer.value(value.lineHeight)

            writer.name(KEY_FONT_FAMILY)
            writer.value(value.fontFamily)

            writer.name(KEY_ALIGN)
            val align = when(value.align){
                TextAlign.CENTER -> "center"
                TextAlign.RIGHT -> "right"
                else -> "left"
            }
            writer.value(align)

            writer.endObject()
        }
    }


}
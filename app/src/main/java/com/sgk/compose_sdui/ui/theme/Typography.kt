package com.sgk.compose_sdui.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.sgk.compose_sdui.R

val oscineFont = FontFamily(
    Font(R.font.oscine_light, FontWeight.Light),
    Font(R.font.oscine_regular, FontWeight.Normal),
//    Font(R.font.oscine_bold, FontWeight.Medium),
    Font(R.font.oscine_bold, FontWeight.Bold),
    Font(R.font.oscine_extra_bold, FontWeight.ExtraBold)
)

val trimFont = FontFamily(
    Font(R.font.trim_light, FontWeight.Light),
    Font(R.font.trim_regular, FontWeight.Normal),
    Font(R.font.trim_medium, FontWeight.Medium),
    Font(R.font.trim_bold, FontWeight.Bold),
    Font(R.font.trim_extra_bold, FontWeight.ExtraBold)
)

val trimCondensendFont = FontFamily(
    Font(R.font.trim_condensed_text_regular, FontWeight.Normal),
    Font(R.font.trim_condensed_display_bold, FontWeight.Bold),
)

fun String.getFontFamily() : FontFamily {
    return when(this){
        "trim" -> trimFont
        "trimCondensend" -> trimCondensendFont
        else -> oscineFont
    }
}

fun String.getFont() : Font{
    return when(this){
        "light" -> Font(R.font.oscine_light, FontWeight.Light)
        "regular" -> Font(R.font.oscine_regular, FontWeight.Normal)
        "bold" -> Font(R.font.oscine_bold, FontWeight.Bold)
        "extra_bold" -> Font(R.font.oscine_extra_bold, FontWeight.Bold)
        else -> Font(R.font.oscine_regular, FontWeight.Normal)
    }
}
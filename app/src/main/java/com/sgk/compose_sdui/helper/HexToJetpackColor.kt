package com.sgk.compose_sdui.helper

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color = Color(android.graphics.Color.parseColor(this))
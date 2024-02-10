package com.sgk.ui.helpers

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color = Color(android.graphics.Color.parseColor(this))
package com.sgk.foodapphomepagesdui.ui.widgets.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

/**
 * It's not recommended to use semantics to test the
 * UI properties like color, size, background, etc.
 *
 * Semantics testing is a replacement until compose release
 * a recommended way to do this
 */

val TextColorKey = SemanticsPropertyKey<String?>("TextColor")
var SemanticsPropertyReceiver.textColor by TextColorKey

val TextSizeKey = SemanticsPropertyKey<Int?>("TextSize")
var SemanticsPropertyReceiver.textSize by TextSizeKey

val IsTextBoldKey = SemanticsPropertyKey<Boolean?>("IsTextBold")
var SemanticsPropertyReceiver.isTextBold by IsTextBoldKey

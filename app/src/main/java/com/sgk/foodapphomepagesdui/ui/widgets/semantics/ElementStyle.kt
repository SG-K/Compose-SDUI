package com.sgk.foodapphomepagesdui.ui.widgets.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding

val WidthKey = SemanticsPropertyKey<Length?>("Width")
var SemanticsPropertyReceiver.width by WidthKey

val HeightKey = SemanticsPropertyKey<Length?>("Height")
var SemanticsPropertyReceiver.height by HeightKey

val PaddingKey = SemanticsPropertyKey<Padding?>("Padding")
var SemanticsPropertyReceiver.padding by PaddingKey

val BackgroundKey = SemanticsPropertyKey<String?>("Background")
var SemanticsPropertyReceiver.background by BackgroundKey

val LayoutIdKey = SemanticsPropertyKey<String?>("LayoutId")
var SemanticsPropertyReceiver.layoutId by LayoutIdKey
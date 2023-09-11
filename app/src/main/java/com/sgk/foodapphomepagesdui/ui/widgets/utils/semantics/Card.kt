package com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver

val CardRadiusKey = SemanticsPropertyKey<Int?>("CardRadius")
var SemanticsPropertyReceiver.cardRadius by CardRadiusKey

val CardContentColorKey = SemanticsPropertyKey<String?>("CardContentColor")
var SemanticsPropertyReceiver.cardContentColor by CardContentColorKey

val CardElevationKey = SemanticsPropertyKey<Int?>("CardElevation")
var SemanticsPropertyReceiver.cardElevation by CardElevationKey
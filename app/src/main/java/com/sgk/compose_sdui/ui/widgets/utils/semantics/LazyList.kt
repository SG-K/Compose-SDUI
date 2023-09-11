package com.sgk.compose_sdui.ui.widgets.utils.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import com.sgk.sduicore.modal.metadata.Orientation

val OrientationKey = SemanticsPropertyKey<Orientation>("Orientation")
var SemanticsPropertyReceiver.orientation by OrientationKey
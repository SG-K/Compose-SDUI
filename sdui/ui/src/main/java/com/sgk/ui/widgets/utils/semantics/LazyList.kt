package com.sgk.ui.widgets.utils.semantics

import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import com.sgk.model.modal.metadata.Orientation

val OrientationKey = SemanticsPropertyKey<Orientation>("Orientation")
var SemanticsPropertyReceiver.orientation by OrientationKey
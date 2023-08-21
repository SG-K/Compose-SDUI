package com.sgk.foodapphomepagesdui.ui.widgets.semantics

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.metadata.Length

val ImageUrlKey = SemanticsPropertyKey<String?>("ImageUrl")
var SemanticsPropertyReceiver.imageUrl by ImageUrlKey

val ImageTypeKey = SemanticsPropertyKey<ImageType?>("ImageType")
var SemanticsPropertyReceiver.imageType by ImageTypeKey

val TintKey = SemanticsPropertyKey<String?>("Tint")
var SemanticsPropertyReceiver.tint by TintKey

val VectorUrlKey = SemanticsPropertyKey<ImageVector?>("VectorUrl")
var SemanticsPropertyReceiver.vectorUrl by VectorUrlKey
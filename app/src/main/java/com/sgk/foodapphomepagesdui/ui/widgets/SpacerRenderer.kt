package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import com.sgk.sduicore.modal.Spacer as SpacerElement


@Composable
fun SpacerRenderer(element: SpacerElement) {
    Spacer(
        modifier = element.style?.asModifier()?.layoutId(element.id) ?: Modifier.layoutId(element.id)
    )
}
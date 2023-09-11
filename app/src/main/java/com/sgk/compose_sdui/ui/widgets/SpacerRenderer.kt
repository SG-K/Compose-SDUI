package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import com.sgk.sduicore.modal.Spacer as SpacerElement


@Composable
fun SpacerRenderer(element: SpacerElement) {
    Spacer(
        modifier = element.style.asModifier()
    )
}
package com.sgk.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import com.sgk.model.modal.Spacer as SpacerElement


@Composable
fun SpacerRenderer(element: SpacerElement) {
    Spacer(
        modifier = element.style.asModifier()
    )
}
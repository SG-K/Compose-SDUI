package com.sgk.compose_sdui.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sgk.sduicore.modal.metadata.Background
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.Box as BoxElement

@Composable
fun BoxRenderer(element: BoxElement) {
    Box(
        modifier = element
            .style
            .asModifier()
    )
}

@Preview
@Composable
fun BoxRendererPreview(){
    val element = BoxElement(
        style = ElementStyle(
            id = "box_space_one",
            width = Length.Number(50),
            height = Length.Number(10),
            background = Background(
                colors = listOf("#FF0000")
            )
        )
    )
    BoxRenderer(
        element
    )
}
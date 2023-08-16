package com.sgk.foodapphomepagesdui.ui.widgets.constraint_layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.foodapphomepagesdui.ui.widgets.CompositeRenderer
import com.sgk.foodapphomepagesdui.ui.widgets.asModifier

@Composable
fun ConstraintLayoutRenderer(
    element: com.sgk.sduicore.modal.ConstraintLayout
) {
    ConstraintLayout(
        constraintSet = element.childernConstrainsList?.handleContraintsSets()?: ConstraintSet {  },
        modifier = element
            .style?.asModifier()
            ?.layoutId(element.id) ?: Modifier
    ) {
        element.children?.forEach { child ->
            CompositeRenderer(element = child)
        }
    }
}


@Composable
@Preview
fun ConstraintLayoutRendererPreview(){
    ConstraintLayoutRenderer(
        element = com.sgk.sduicore.modal.ConstraintLayout(
            children = emptyList(),
            childernConstrainsList = emptyList(),
            style = ElementStyle(
                width = Length.Max,
                height = Length.Number(60),
                background = "Red",
            ),
            id = "root"
        )
    )

//    ColumnRenderer(
//        element = Column(
//            children = emptyList(),
//            style = ElementStyle(
//                width = Length.Max,
//                height = Length.Number(60),
//                background = "Red",
//            ),
//            id = "root"
//        )
//    )
}
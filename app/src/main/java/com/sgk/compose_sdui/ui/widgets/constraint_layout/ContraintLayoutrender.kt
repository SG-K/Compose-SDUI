package com.sgk.compose_sdui.ui.widgets.constraint_layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.sgk.model.modal.ConstraintLayout
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Length
import com.sgk.compose_sdui.ui.widgets.CompositeRenderer
import com.sgk.compose_sdui.ui.widgets.asModifier
import com.sgk.model.modal.ChildConstraintModel
import com.sgk.model.modal.ContraintDirections
import com.sgk.model.modal.ContraintHeightWidth
import com.sgk.model.modal.DirectionConstraints
import com.sgk.model.modal.Image
import com.sgk.model.modal.ImageType
import com.sgk.model.modal.Text
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle

@Composable
fun ConstraintLayoutRenderer(
    element: ConstraintLayout
) {
    ConstraintLayout(
        constraintSet = element.childernConstrainsList?.handleContraintsSets()?: ConstraintSet {  },
        modifier = element
            .style.asModifier()
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
        element = ConstraintLayout(
            children = listOf(
                Text(
                    text = "Password",
                    textStyle = TextStyle(
                        textSize = 16,
                        textColor = "#000000",
                        isBold = false
                    ),
                    style = ElementStyle(
                        id = "card_password_lable",
                        background = "#FF0000",
                        width = Length.Max
                    )
                ),
                Text(
                    text = "***********",
                    textStyle = TextStyle(
                        textSize = 16,
                        textColor = "#000000",
                        isBold = false
                    ),
                    style = ElementStyle(
                        id = "card_password_text",
                        padding = Padding(
                            top = 16,
                            bottom = 0,
                            left = 0,
                            right = 0
                        )
                    )
                ),
                Image(
                    url = "edit",
                    altText = "Edit Password",
                    imageType = ImageType.IMAGE_VECTOR,
                    style = ElementStyle(
                        width = Length.Number(24),
                        height = Length.Number(24),
                        id = "card_password_edit"
                    ),
                    tint = "#d33671"
                )
            ),
            childernConstrainsList = listOf(
                ChildConstraintModel(
                    refId = "card_password_lable",
                    top = DirectionConstraints(
                        contraintDirection = ContraintDirections.TOP,
                        constraintComposableId = "-101",
                        margin = 0
                    ),
                    start = DirectionConstraints(
                        contraintDirection = ContraintDirections.START,
                        constraintComposableId = "-101",
                        margin = 0
                    ),
                    end = DirectionConstraints(
                        contraintDirection = ContraintDirections.START,
                        constraintComposableId = "card_password_edit",
                        margin = 0
                    ),
                    width_constraint = ContraintHeightWidth.FILL_TO_CONSTRAINTS
                ),


                ChildConstraintModel(
                    refId = "card_password_text",
                    top = DirectionConstraints(
                        contraintDirection = ContraintDirections.BOTTOM,
                        constraintComposableId = "card_password_lable",
                        margin = 0
                    ),
                    start = DirectionConstraints(
                        contraintDirection = ContraintDirections.START,
                        constraintComposableId = "-101",
                        margin = 0
                    )
                ),

                ChildConstraintModel(
                    refId = "card_password_edit",
                    top = DirectionConstraints(
                        contraintDirection = ContraintDirections.TOP,
                        constraintComposableId = "card_password_lable",
                        margin = 0
                    ),
                    end = DirectionConstraints(
                        contraintDirection = ContraintDirections.END,
                        constraintComposableId = "-101",
                        margin = 0
                    )
                ),


            ),
            style = ElementStyle(
                id = "contraint_layout_password",
                width = Length.Max,
                padding = Padding(
                    top = 16,
                    bottom = 16,
                    left = 16,
                    right = 16
                ),
                background = "#FFFFFF"
            )
        )
    )

}
package com.sgk.compose_sdui.ui.widgets.constraint_layout

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertLeftPositionInRootIsEqualTo
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.assertTopPositionInRootIsEqualTo
import androidx.compose.ui.test.getBoundsInRoot
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.sgk.compose_sdui.base.BaseComposeTest
import com.sgk.compose_sdui.ui.widgets.elementStyleTests
import com.sgk.ui.widgets.image.getImageVector
import com.sgk.ui.widgets.utils.semantics.VectorUrlKey
import com.sgk.model.modal.ChildConstraintModel
import com.sgk.model.modal.ConstraintLayout
import com.sgk.model.modal.ContraintDirections
import com.sgk.model.modal.ContraintHeightWidth
import com.sgk.model.modal.DirectionConstraints
import com.sgk.model.modal.Image
import com.sgk.model.modal.ImageType
import com.sgk.model.modal.Text
import com.sgk.model.modal.metadata.ElementStyle
import com.sgk.model.modal.metadata.Length
import com.sgk.model.modal.metadata.Padding
import com.sgk.model.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Test


@HiltAndroidTest
class ContraintLayoutrenderKtTest : BaseComposeTest<ConstraintLayout>(){

    override fun setData(): ConstraintLayout {
        return ConstraintLayout(
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
    }

    @Composable
    override fun SetContent() {
        com.sgk.ui.widgets.constraint_layout.ConstraintLayoutRenderer(element = element)
    }

    @Test
    override fun testExecution() {
        element.testWidget(composeTestRule)
        testConstraintLayoutContents()
    }
    

    fun testConstraintLayoutContents(){

        val placementsOfChild1 = composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .onFirst()
            .getBoundsInRoot()

        val child1 : Text? = element.children?.first() as Text?
        val child2 : Text? = element.children?.get(1) as Text?
        val child3 : Image? = element.children?.last() as Image?

        Log.v("CONSTRAINT_LAYOUT_DEBUG_TAG", "dpData = $placementsOfChild1")

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .printToLog("CONSTRAINT_LAYOUT_DEBUG_TAG")

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .assertCountEquals(element.childernConstrainsList?.size?:0)

        // region test cases for placements of the childern
        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .onFirst()
            .assertIsDisplayed()
            .assertLeftPositionInRootIsEqualTo(
                ((element.style?.padding?.left ?:0) +
                        (element.children?.first()?.style?.padding?.left ?:0)
                        ).dp
            )
            .assertTopPositionInRootIsEqualTo(
                ((element.style?.padding?.top ?:0) +
                        (element.children?.first()?.style?.padding?.top ?:0)
                        ).dp
            )


        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .get(1)
            .assertIsDisplayed()
            .assertLeftPositionInRootIsEqualTo(
                ((element.style?.padding?.left ?:0) +
                        (element.children?.get(1)?.style?.padding?.left ?:0)
                        ).dp
            )
            .assertTopPositionInRootIsEqualTo(
                ( (element.children?.get(1)?.style?.padding?.top ?:0)
                        ).dp + placementsOfChild1.bottom
            )

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .onLast()
            .assertIsDisplayed()
            .assertTopPositionInRootIsEqualTo(
                placementsOfChild1.top
            )
            .assertLeftPositionInRootIsEqualTo(
                placementsOfChild1.right
            )

        // endregion

        // region Data matching test cases

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .onFirst()
            .assertTextEquals(
                child1?.text?:""
            )

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .get(1)
            .assertTextEquals(
                child2?.text?:""
            )

        composeTestRule
            .onNode(hasTestTag(element.style?.id?:""))
            .onChildren()
            .onLast()
            .assertExists()
            .assert(
                SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.VectorUrlKey, child3?.url?.getImageVector())
            )

        // endregion

    }

    fun dpToPx(
        dp: Int,
    ): Int {
        val context: Context = InstrumentationRegistry.getInstrumentation().getTargetContext()
        val displayMetrics: DisplayMetrics = context.getResources().getDisplayMetrics()
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

}

fun ConstraintLayout.testWidget(
    composeTestRule : ComposeContentTestRule
){
    composeTestRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeTestRule)

    Assert.assertEquals(children?.size, childernConstrainsList?.size)

}
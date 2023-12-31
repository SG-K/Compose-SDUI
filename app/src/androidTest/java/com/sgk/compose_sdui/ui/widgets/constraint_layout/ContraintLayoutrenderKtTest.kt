package com.sgk.compose_sdui.ui.widgets.constraint_layout

import android.content.Context
import android.util.DisplayMetrics
import android.util.Log
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
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import androidx.test.platform.app.InstrumentationRegistry
import com.sgk.compose_sdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.compose_sdui.ui.widgets.elementStyleTests
import com.sgk.compose_sdui.ui.widgets.image.getImageVector
import com.sgk.compose_sdui.ui.widgets.utils.semantics.VectorUrlKey
import com.sgk.sduicore.modal.ChildConstraintModel
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.ContraintDirections
import com.sgk.sduicore.modal.ContraintHeightWidth
import com.sgk.sduicore.modal.DirectionConstraints
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.ImageType
import com.sgk.sduicore.modal.Text
import com.sgk.sduicore.modal.metadata.ElementStyle
import com.sgk.sduicore.modal.metadata.Length
import com.sgk.sduicore.modal.metadata.Padding
import com.sgk.sduicore.modal.metadata.TextStyle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class ContraintLayoutrenderKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    val constraintLayoutData = ConstraintLayout(
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

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                ConstraintLayoutRenderer(element = constraintLayoutData)
            }
        }
    }

    @Test
    fun testConstraintLayoutDisplay(){
        constraintLayoutData.testWidget(composeRule)
    }

    @Test
    fun testConstraintLayoutContents(){

        val placementsOfChild1 = composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .onFirst()
            .getBoundsInRoot()

        val child1 : Text? = constraintLayoutData.children?.first() as Text?
        val child2 : Text? = constraintLayoutData.children?.get(1) as Text?
        val child3 : Image? = constraintLayoutData.children?.last() as Image?

        Log.v("CONSTRAINT_LAYOUT_DEBUG_TAG", "dpData = $placementsOfChild1")

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .printToLog("CONSTRAINT_LAYOUT_DEBUG_TAG")

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .assertCountEquals(constraintLayoutData.childernConstrainsList?.size?:0)

        // region test cases for placements of the childern
        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .onFirst()
            .assertIsDisplayed()
            .assertLeftPositionInRootIsEqualTo(
                ((constraintLayoutData.style?.padding?.left ?:0) +
                        (constraintLayoutData.children?.first()?.style?.padding?.left ?:0)
                        ).dp
            )
            .assertTopPositionInRootIsEqualTo(
                ((constraintLayoutData.style?.padding?.top ?:0) +
                        (constraintLayoutData.children?.first()?.style?.padding?.top ?:0)
                        ).dp
            )


        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .get(1)
            .assertIsDisplayed()
            .assertLeftPositionInRootIsEqualTo(
                ((constraintLayoutData.style?.padding?.left ?:0) +
                        (constraintLayoutData.children?.get(1)?.style?.padding?.left ?:0)
                        ).dp
            )
            .assertTopPositionInRootIsEqualTo(
                ( (constraintLayoutData.children?.get(1)?.style?.padding?.top ?:0)
                        ).dp + placementsOfChild1.bottom
            )

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
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

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .onFirst()
            .assertTextEquals(
                child1?.text?:""
            )

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .get(1)
            .assertTextEquals(
                child2?.text?:""
            )

        composeRule
            .onNode(hasTestTag(constraintLayoutData.style?.id?:""))
            .onChildren()
            .onLast()
            .assertExists()
            .assert(
                SemanticsMatcher.expectValue(VectorUrlKey, child3?.url?.getImageVector())
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
    composeRule : ComposeContentTestRule
){
    composeRule
        .onNode(hasTestTag(style?.id?:""))
        .assertExists()
        .assertIsDisplayed()

    style?.elementStyleTests(composeRule)

    Assert.assertEquals(children?.size, childernConstrainsList?.size)

}
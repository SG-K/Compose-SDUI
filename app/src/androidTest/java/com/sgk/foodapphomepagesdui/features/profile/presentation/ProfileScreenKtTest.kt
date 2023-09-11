package com.sgk.foodapphomepagesdui.features.profile.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertLeftPositionInRootIsEqualTo
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.assertTopPositionInRootIsEqualTo
import androidx.compose.ui.test.getBoundsInRoot
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.printToLog
import androidx.compose.ui.unit.dp
import com.sgk.foodapphomepagesdui.di.HomePageJsonTestDataAnnotation
import com.sgk.foodapphomepagesdui.features.profile.domain.use_case.GetProfilePageData
import com.sgk.foodapphomepagesdui.ui.theme.FoodAppHomePageSDUITheme
import com.sgk.foodapphomepagesdui.ui.widgets.elementStyleTests
import com.sgk.foodapphomepagesdui.ui.widgets.image.getImageVector
import com.sgk.foodapphomepagesdui.ui.widgets.image_render.testWidget
import com.sgk.foodapphomepagesdui.ui.widgets.testTextStyle
import com.sgk.foodapphomepagesdui.ui.widgets.testWidget
import com.sgk.foodapphomepagesdui.ui.widgets.utils.semantics.VectorUrlKey
import com.sgk.sduicore.modal.Card
import com.sgk.sduicore.modal.ConstraintLayout
import com.sgk.sduicore.modal.Element
import com.sgk.sduicore.modal.Image
import com.sgk.sduicore.modal.LazyList
import com.sgk.sduicore.modal.Row
import com.sgk.sduicore.modal.Text
import com.squareup.moshi.Moshi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltAndroidTest
class ProfileScreenKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createComposeRule()

    @Inject
    lateinit var getProfilePageData: GetProfilePageData

    @Inject
    lateinit var moshi: Moshi

    @HomePageJsonTestDataAnnotation
    @Inject lateinit var jsonData: String

    lateinit var element : Element

    @Before
    fun setUp(){
        hiltRule.inject()
        element = moshi.adapter(Element::class.java).fromJson(jsonData)!!
        composeRule.setContent {
            FoodAppHomePageSDUITheme {
                ProfileScreen(
                    getProfilePageData = getProfilePageData,
                    moshi = moshi
                )
            }
        }
    }

    @Test
    fun rootLayoutDisplayAndPropertTesting(){
        composeRule
            .onNode(
                hasTestTag(element.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        element.style?.elementStyleTests(composeRule)

        val constraintLayout = element as ConstraintLayout

        composeRule
            .onNode(
                hasTestTag(element.style!!.id!!)
            )
            .onChildren()
            .assertCountEquals(constraintLayout.children?.size?:0)

    }

    @Test
    fun headerUITesting(){
        val constraintLayout = element as ConstraintLayout
        val child1 = constraintLayout.children!!.first() as ConstraintLayout

        composeRule
            .onNode(
                hasTestTag(child1.style!!.id!!)
            )
            .printToLog("CHILD_1")

        //region root contents and styles testing
        composeRule
            .onNode(
                hasTestTag(child1.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        child1.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(child1.style!!.id!!)
            )
            .onChildren()
            .assertCountEquals(child1.children?.size?:0)

        assertEquals(child1.children?.size, child1.childernConstrainsList?.size)

        //endregion

        // region child 1 contents and styles testing
        val child1_1 = child1.children?.get(0) as Image

        composeRule
            .onNode(
                hasTestTag(child1_1.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        child1_1.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(child1_1.style!!.id!!)
            )
            .assert(
                SemanticsMatcher.expectValue(
                    VectorUrlKey,
                    child1_1.url.getImageVector()
                )
            )

        // endregion

        //region child 2 contents and styles testing

        val child1_2 = child1.children?.get(1) as Text

        composeRule
            .onNode(
                hasTestTag(child1_2.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        child1_2.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(child1_2.style!!.id!!)
            )
            .assertTextEquals(
                child1_2.text
            )

        child1_2.textStyle.testTextStyle(composeRule, child1_2.style?.id!!)

        //endregion

        //region Childern placesments testing

        val child1_1_bounds = composeRule
            .onNode(
                hasTestTag(child1_1.style!!.id!!)
            )
            .getBoundsInRoot()

        val child1_2_bounds = composeRule
            .onNode(
                hasTestTag(child1_2.style!!.id!!)
            )
            .getBoundsInRoot()

        val tempBounds = (60 - 24)/2

        composeRule
            .onNode(
                hasTestTag(child1_1.style!!.id!!)
            )
            .assertLeftPositionInRootIsEqualTo(
                ((child1.childernConstrainsList?.get(0)?.start?.margin ?: 0)
                        + (child1_1.style?.padding?.left?: 0)).dp
            )
            .assertTopPositionInRootIsEqualTo(
                tempBounds.dp
            )

        val child1_2_height = child1_2_bounds.bottom - child1_2_bounds.top
        val child1_2_temp_bound = (60.dp - child1_2_height) / 2

        composeRule
            .onNode(
                hasTestTag(child1_2.style!!.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                child1_2_temp_bound
            )

        assert(child1_1_bounds.right < child1_2_bounds.left)

        // endregion

    }

    @Test
    fun listUITesting(){
        val constraintLayout = element as ConstraintLayout
        val lazylist = constraintLayout.children!!.get(1) as LazyList

        composeRule
            .onNode(
                hasTestTag(lazylist.style!!.id!!)
            )
            .printToLog("child_2")

        //region root contents and styles testing
        composeRule
            .onNode(
                hasTestTag(lazylist.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        lazylist.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(lazylist.style!!.id!!)
            )
            .onChildren()
            .assertCountEquals(lazylist.children.size)

        //endregion

        passwordCardUiTesting(
            lazylist.children[0].element as Card
        )
        mobileNumberCardUiTesting(
            lazylist.children[1].element as Card
        )

    }

    fun passwordCardUiTesting(
        card: Card
    ){

        val cardBounds = composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .getBoundsInRoot()

        composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .printToLog("card_password")

        composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        card.style?.elementStyleTests(composeRule)

        val constraintLayout = card.child as ConstraintLayout

        composeRule
            .onNode(
                hasTestTag(constraintLayout.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        constraintLayout.style?.elementStyleTests(composeRule)

        assertEquals(
            constraintLayout.children?.size?:0,
            constraintLayout.childernConstrainsList?.size?:0
        )

        val child1 = constraintLayout.children?.first() as Text
        val child2 = constraintLayout.children?.get(1) as Text
        val child3 = constraintLayout.children?.last() as Image

        child1.testWidget(composeRule)
        child2.testWidget(composeRule)
        child3.testWidget(
            composeRule = composeRule,
            imageVector = Icons.Outlined.Edit
        )

        val child1Bound = composeRule
            .onNode(
                hasTestTag(child1.style?.id!!)
            )
            .getBoundsInRoot()

        composeRule
            .onNode(
                hasTestTag(child1.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                cardBounds.top +
                    (constraintLayout.style?.padding?.top?:0).dp +
                        (child1.style?.padding?.top?:0).dp
            )
            .assertLeftPositionInRootIsEqualTo(
                cardBounds.left +
                        (constraintLayout.style?.padding?.left?:0).dp +
                        (child1.style?.padding?.left?:0).dp
            )

        composeRule
            .onNode(
                hasTestTag(child2.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                child1Bound.bottom +
                        (child2.style?.padding?.top?:0).dp
            )
            .assertLeftPositionInRootIsEqualTo(
                cardBounds.left +
                        (constraintLayout.style?.padding?.left?:0).dp +
                        (child2.style?.padding?.left?:0).dp
            )


        composeRule
            .onNode(
                hasTestTag(child3.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                cardBounds.top +
                        (constraintLayout.style?.padding?.top?:0).dp +
                        (child3.style?.padding?.top?:0).dp
            )

    }

    fun mobileNumberCardUiTesting(
        card: Card
    ){
        val cardBounds = composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .getBoundsInRoot()

        composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .printToLog("card_mobile")

        composeRule
            .onNode(
                hasTestTag(card.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        card.style?.elementStyleTests(composeRule)

        val constraintLayout = card.child as ConstraintLayout

        composeRule
            .onNode(
                hasTestTag(constraintLayout.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        constraintLayout.style?.elementStyleTests(composeRule)

        assertEquals(
            constraintLayout.children?.size?:0,
            constraintLayout.childernConstrainsList?.size?:0
        )

        val child1 = constraintLayout.children?.first() as Text
        val child2 = constraintLayout.children?.get(1) as Text
        val child3 = constraintLayout.children?.get(2) as Image
        val child4 = constraintLayout.children?.last() as Card
        val verifiedRow = child4.child as Row
        val child4_1 = verifiedRow.children.first() as Image
        val child4_2 = verifiedRow.children.last() as Text

        child1.testWidget(composeRule)
        child2.testWidget(composeRule)
        child3.testWidget(
            composeRule = composeRule,
            imageVector = Icons.Outlined.Edit
        )
        child4.testWidget(composeRule)
        child4_1.testWidget(
            composeRule = composeRule,
            imageVector = Icons.Outlined.Check
        )
        child4_2.testWidget(composeRule)

        val child1Bound = composeRule
            .onNode(
                hasTestTag(child1.style?.id!!)
            )
            .getBoundsInRoot()
        val child2Bound = composeRule
            .onNode(
                hasTestTag(child2.style?.id!!)
            )
            .getBoundsInRoot()

        composeRule
            .onNode(
                hasTestTag(child1.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                cardBounds.top +
                        (constraintLayout.style?.padding?.top?:0).dp +
                        (child1.style?.padding?.top?:0).dp
            )
            .assertLeftPositionInRootIsEqualTo(
                cardBounds.left +
                        (constraintLayout.style?.padding?.left?:0).dp +
                        (child1.style?.padding?.left?:0).dp
            )

        composeRule
            .onNode(
                hasTestTag(child2.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                child1Bound.bottom +
                        (child2.style?.padding?.top?:0).dp
            )
            .assertLeftPositionInRootIsEqualTo(
                cardBounds.left +
                        (constraintLayout.style?.padding?.left?:0).dp +
                        (child2.style?.padding?.left?:0).dp
            )


        composeRule
            .onNode(
                hasTestTag(child3.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                cardBounds.top +
                        (constraintLayout.style?.padding?.top?:0).dp +
                        (child3.style?.padding?.top?:0).dp
            )

        composeRule
            .onNode(
                hasTestTag(child4.style?.id!!)
            )
            .assertTopPositionInRootIsEqualTo(
                child2Bound.bottom +
                        (child2.style?.padding?.top?:0).dp +
                        (child4.style?.padding?.top?:0).dp
            )
            .assertLeftPositionInRootIsEqualTo(
                cardBounds.left +
                        (constraintLayout.style?.padding?.left?:0).dp +
                        (child4.style?.padding?.left?:0).dp
            )

        val child4_1Bounds = composeRule
            .onNode(
                hasTestTag(child4_1.style?.id!!)
            )
            .getBoundsInRoot()
        val child4_2Bounds = composeRule
            .onNode(
                hasTestTag(child4_2.style?.id!!)
            )
            .getBoundsInRoot()

        assert(child4_1Bounds.right < child4_2Bounds.left)

    }

    @Test
    fun footerUITesting(){
        val constraintLayout = element as ConstraintLayout
        val child3 = constraintLayout.children!!.last() as ConstraintLayout

        composeRule
            .onNode(
                hasTestTag(child3.style!!.id!!)
            )
            .printToLog("CHILD_3")


        //region root contents and styles testing
        composeRule
            .onNode(
                hasTestTag(child3.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        child3.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(child3.style!!.id!!)
            )
            .onChildren()
            .assertCountEquals(child3.children?.size?:0)

        assertEquals(child3.children?.size, child3.childernConstrainsList?.size)

        //endregion

        //region child 1 contents and styles testing

        val child3_1 = child3.children?.get(0) as Text

        composeRule
            .onNode(
                hasTestTag(child3_1.style!!.id!!)
            )
            .assertExists()
            .assertIsDisplayed()

        child3_1.style?.elementStyleTests(composeRule)

        composeRule
            .onNode(
                hasTestTag(child3_1.style!!.id!!)
            )
            .assertTextEquals(
                child3_1.text
            )

        child3_1.textStyle.testTextStyle(composeRule, child3_1.style?.id!!)

        //endregion

        // region child 1 placement

        val child3Bounds = composeRule
            .onNode(
                hasTestTag(child3.style!!.id!!)
            )
            .getBoundsInRoot()
        val child3_1Bounds = composeRule
            .onNode(
                hasTestTag(child3_1.style!!.id!!)
            )
            .getBoundsInRoot()

        val topDifference = child3_1Bounds.top - child3Bounds.top
        val bottomDifference = child3Bounds.bottom - child3_1Bounds.bottom

        assertEquals(topDifference.value.roundToInt(),bottomDifference.value.roundToInt())

        val leftDifference = child3_1Bounds.left - child3Bounds.left
        val rightDifference = child3Bounds.right - child3_1Bounds.right

        assertEquals(leftDifference.value.roundToInt(),rightDifference.value.roundToInt())

        //endregion

    }

}
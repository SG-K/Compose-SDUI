package com.sgk.foodapphomepagesdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithText
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.BackgroundKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.HeightKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.PaddingKey
import com.sgk.foodapphomepagesdui.ui.widgets.semantics.WidthKey
import com.sgk.sduicore.modal.metadata.ElementStyle

fun ElementStyle.elementStyleTests(
    composeRule : ComposeContentTestRule
){

    id?.let{

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assertExists()

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(WidthKey, width)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(HeightKey, height)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(PaddingKey, padding)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(BackgroundKey, background)
            )

    }
}
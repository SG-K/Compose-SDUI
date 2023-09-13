package com.sgk.compose_sdui.ui.widgets

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import com.sgk.ui.widgets.utils.semantics.BackgroundKey
import com.sgk.ui.widgets.utils.semantics.HeightKey
import com.sgk.ui.widgets.utils.semantics.PaddingKey
import com.sgk.ui.widgets.utils.semantics.WidthKey
import com.sgk.model.modal.metadata.ElementStyle

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
                SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.WidthKey, width)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.HeightKey, height)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.PaddingKey, padding)
            )

        composeRule
            .onNode(
                hasTestTag(it)
            )
            .assert(
                SemanticsMatcher.expectValue(com.sgk.ui.widgets.utils.semantics.BackgroundKey, background)
            )

    }
}
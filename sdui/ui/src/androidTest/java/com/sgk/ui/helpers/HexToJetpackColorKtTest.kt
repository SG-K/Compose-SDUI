package com.sgk.ui.helpers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import com.sgk.ui.helpers.toColor
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class HexToJetpackColorKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createComposeRule()

    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun testColorConversion() {
        val colorString = "#FF0000" // Red color
        val color = colorString.toColor()
        // Verify that the color was converted correctly
        assertEquals(Color.Red, color)
    }

    @Test
    fun testInvalidColorConversion() {
        val invalidColorString = "invalid_color"
        // Attempt to convert an invalid color string
        val color = try {
            invalidColorString.toColor()
        } catch (e: IllegalArgumentException) {
            null
        }
        // Verify that the function throws an IllegalArgumentException for invalid input
        assertEquals(null, color)
    }

}
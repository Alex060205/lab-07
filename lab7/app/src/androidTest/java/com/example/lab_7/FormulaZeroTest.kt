package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity
    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
    @Test
    fun navigate_to_drivers_add_clear_and_return_home() {
        composeTestRule
            .onNodeWithTag("driveButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Upcoming Drivers")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Alex")

        composeTestRule
            .onNodeWithTag("addDRiverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Alex")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Tiffany")

        composeTestRule
            .onNodeWithTag("addDRiverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Tiffany")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearAllDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()


    }
}

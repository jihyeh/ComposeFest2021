package com.example.compose.rally

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

/**
 * 참고 블로그
 * https://www.charlezz.com/?p=45766
 * */
class Exercise {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_clickTabs() {
        var currentScreen = RallyScreen.Overview
        composeTestRule.setContent {
            RallyApp(currentScreen) {
                currentScreen = it
            }
        }

        RallyScreen.values().forEach { screen ->
            composeTestRule
                .onNodeWithContentDescription(screen.name)
                .performClick()
            assert(currentScreen == screen)
        }
    }
}
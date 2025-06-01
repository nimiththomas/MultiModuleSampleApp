package com.picker.feature1.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.picker.feature1.screens.Feature1Screen

const val FEATURE1_MAIN_ROUTE = "feature1_main_route"
const val FEATURE_1 = "feature1"

fun NavGraphBuilder.feature1(goToNextScreen: () -> Unit) {
    navigation(route = FEATURE1_MAIN_ROUTE, startDestination = FEATURE_1) {
        composable(FEATURE_1) {
            Feature1Screen(goToNextScreen)
        }

    }
}
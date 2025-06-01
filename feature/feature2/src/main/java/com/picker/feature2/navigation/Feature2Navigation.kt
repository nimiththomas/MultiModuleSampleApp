package com.picker.feature2.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.picker.feature2.screens.Feature2Screen

const val FEATURE2_MAIN_ROUTE = "feature2_main_route"
const val FEATURE_2 = "feature2"

fun NavGraphBuilder.feature2(goBack: () -> Unit) {
    navigation(route = FEATURE2_MAIN_ROUTE, startDestination = FEATURE_2) {
        composable(FEATURE_2) {
            Feature2Screen(goBack)
        }

    }
}

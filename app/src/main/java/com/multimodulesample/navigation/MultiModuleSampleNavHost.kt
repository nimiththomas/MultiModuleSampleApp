package com.multimodulesample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.picker.feature1.navigation.FEATURE1_MAIN_ROUTE
import com.picker.feature1.navigation.feature1
import com.picker.feature2.navigation.feature2


@Composable
fun MultiModuleSampleNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FEATURE1_MAIN_ROUTE,
        modifier = modifier
    ) {
        feature1 {
            navController.navigate("feature2")
        }
        feature2 {
            navController.popBackStack()
        }
    }

}
package com.multimodulesample.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

object ComposableExtensions {

    @Composable
    inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
        val navGraphRoute = destination.parent?.route ?: return hiltViewModel<T>()
        val parentEntry = remember(this) {
            navController
                .getBackStackEntry(navGraphRoute)
        }
        return hiltViewModel<T>(parentEntry)
    }


}
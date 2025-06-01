package com.picker.feature1.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.multimodulesample.designsystem.MultiModuleSampleTheme
import com.multimodulesample.uicomponents.MultiModuleSampleTest
import com.picker.feature1.states.Feature1UiState
import com.picker.feature1.viewmodels.Feature1ViewModel

@Composable
internal fun Feature1Screen(goToNextFeature: () -> Unit) {
    val viewModel = hiltViewModel<Feature1ViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Feature1Screen(state, goToNextFeature)
}

@Composable
internal fun Feature1Screen(state: Feature1UiState, goToNextFeature: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MultiModuleSampleTheme.colors.primaryColor),
        contentAlignment = Alignment.Center
    ) {
        MultiModuleSampleTest("${state.screenName}, Move to next feature", goToNextFeature)
    }
}
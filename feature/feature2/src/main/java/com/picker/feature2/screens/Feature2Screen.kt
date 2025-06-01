package com.picker.feature2.screens

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
import com.picker.feature1.states.Feature2UiState
import com.picker.feature2.viewmodels.Feature2ViewModel

@Composable
internal fun Feature2Screen(goBack: () -> Unit) {
    val viewModel = hiltViewModel<Feature2ViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Feature2Screen(state, goBack)
}

@Composable
internal fun Feature2Screen(state: Feature2UiState, goBack: () -> Unit) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MultiModuleSampleTheme.colors.primaryColor),
        contentAlignment = Alignment.Center
    ) {
        MultiModuleSampleTest("${state.screenName}, Back to feature 1", goBack)
    }
}
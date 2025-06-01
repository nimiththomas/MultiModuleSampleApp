package com.multimodulesample.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multimodulesample.designsystem.MultiModuleSampleTheme

@Composable
fun MultiModuleSampleTest(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        color = MultiModuleSampleTheme.colors.tertarySurfaceColor,
        style = MultiModuleSampleTheme.typography.title1,
        modifier = Modifier.clickable {
            onClick()
        }
    )
}
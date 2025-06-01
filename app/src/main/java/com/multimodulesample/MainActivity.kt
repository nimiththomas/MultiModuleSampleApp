package com.multimodulesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.multimodulesample.designsystem.MultiModuleSampleTheme
import com.multimodulesample.navigation.MultiModuleSampleNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiModuleSampleTheme {
                MultiModuleSampleNavHost(modifier = Modifier.fillMaxSize())

            }
        }
    }
}


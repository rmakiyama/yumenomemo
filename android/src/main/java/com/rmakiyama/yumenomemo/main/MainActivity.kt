package com.rmakiyama.yumenomemo.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.rmakiyama.yumenomemo.home.HomeScreen
import com.rmakiyama.yumenomemo.theme.YumenomemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            YumenomemoTheme {
                ProvideWindowInsets(consumeWindowInsets = false) {
                    HomeScreen()
                }
            }
        }
    }
}

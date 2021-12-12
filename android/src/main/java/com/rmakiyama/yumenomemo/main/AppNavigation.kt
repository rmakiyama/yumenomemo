package com.rmakiyama.yumenomemo.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.rmakiyama.yumenomemo.Screen
import com.rmakiyama.yumenomemo.home.HomeScreen
import com.rmakiyama.yumenomemo.write.WriteScreen

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.WriteYumenomemo.route) {
            WriteScreen(
                navigateUp = { navController.navigateUp() },
                onWriteCompleted = { navController.navigateUp() },
            )
        }
    }
}

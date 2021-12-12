package com.rmakiyama.yumenomemo.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rmakiyama.yumenomemo.Screen
import com.rmakiyama.yumenomemo.theme.fabEnterSpec
import com.rmakiyama.yumenomemo.theme.fabExitSpec

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
internal fun MainScreen() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val needsShowFab: Boolean = fabNeededRoutes.contains(currentRoute)

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(
                visible = needsShowFab,
                enter = scaleIn(fabEnterSpec) + fadeIn(fabEnterSpec),
                exit = scaleOut(fabExitSpec) + fadeOut(fabExitSpec),
            ) {
                LargeFloatingActionButton(
                    onClick = { navController.navigate(Screen.WriteYumenomemo.route) },
                    modifier = Modifier.navigationBarsPadding(),
                    shape = CircleShape,
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add Yumenomemo",
                        modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize),
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { paddingValues ->
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

private val fabNeededRoutes: List<String> = listOf(
    Screen.Home.route,
)

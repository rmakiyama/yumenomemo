package com.rmakiyama.yumenomemo.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmakiyama.yumenomemo.component.YumenomemoListView
import com.rmakiyama.yumenomemo.model.Yumenomemo

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(true) { viewModel.dispatch(HomeViewModel.Action.Launch) }

    HomeScreen(
        yumenomemoList = state.yumenomemoList,
    )
}

@Composable
private fun HomeScreen(
    yumenomemoList: List<Yumenomemo>,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        YumenomemoListView(list = yumenomemoList)
    }
}

package com.rmakiyama.yumenomemo.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.rememberInsetsPaddingValues
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
        if (yumenomemoList.isNotEmpty()) {
            YumenomemoListView(
                list = yumenomemoList,
                contentPadding = rememberInsetsPaddingValues(
                    insets = LocalWindowInsets.current.systemBars,
                    additionalTop = 16.dp,
                    additionalBottom = 144.dp,
                )
            )
        } else {
            EmptyView()
        }
    }
}

@Composable
private fun EmptyView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 144.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "👇🏻", style = MaterialTheme.typography.headlineMedium)
        }
    }
}

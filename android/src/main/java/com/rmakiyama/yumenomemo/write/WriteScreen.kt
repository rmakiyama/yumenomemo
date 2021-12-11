package com.rmakiyama.yumenomemo.write

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.statusBarsPadding
import com.rmakiyama.yumenomemo.R
import com.rmakiyama.yumenomemo.component.NavigationBackIcon
import com.rmakiyama.yumenomemo.write.WriteViewModel.Action.UpdateDetail
import com.rmakiyama.yumenomemo.write.WriteViewModel.Action.UpdateImpression

@Composable
fun WriteScreen(
    navigateUp: () -> Unit,
    onWriteCompleted: () -> Unit,
) {
    val viewModel: WriteViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    WriteScreen(
        detail = state.detail,
        impression = state.impression,
        onDetailChanged = { viewModel.dispatch(UpdateDetail(it)) },
        onImpressionChanged = { viewModel.dispatch(UpdateImpression(it)) },
        onClickNavigationBack = { navigateUp() }
    )
}

@Composable
private fun WriteScreen(
    detail: String,
    impression: String,
    onDetailChanged: (String) -> Unit,
    onImpressionChanged: (String) -> Unit,
    onClickNavigationBack: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column {
            MediumTopAppBar(
                title = { Text(stringResource(R.string.title_write_yumenomemo)) },
                navigationIcon = { NavigationBackIcon { onClickNavigationBack() } },
            )
            BasicTextField(value = detail, onValueChange = onDetailChanged)
            BasicTextField(value = impression, onValueChange = onImpressionChanged)
        }
    }
}

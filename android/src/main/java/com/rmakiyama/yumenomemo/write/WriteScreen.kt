package com.rmakiyama.yumenomemo.write

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.statusBarsPadding
import com.rmakiyama.yumenomemo.R
import com.rmakiyama.yumenomemo.component.NavigationBackIcon
import com.rmakiyama.yumenomemo.write.WriteViewModel.Action.UpdateDetail
import com.rmakiyama.yumenomemo.write.WriteViewModel.Action.UpdateImpression
import com.rmakiyama.yumenomemo.write.WriteViewModel.Action.Write
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect

@InternalCoroutinesApi
@Composable
fun WriteScreen(
    navigateUp: () -> Unit,
    onWriteCompleted: () -> Unit,
) {
    val viewModel: WriteViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    LaunchedEffect(true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                WriteViewModel.Effect.Completed -> onWriteCompleted()
            }
        }
    }

    WriteScreen(
        detail = state.detail,
        impression = state.impression,
        onDetailChanged = { viewModel.dispatch(UpdateDetail(it)) },
        onImpressionChanged = { viewModel.dispatch(UpdateImpression(it)) },
        onClickNavigationBack = { navigateUp() },
        onClickSave = { viewModel.dispatch(Write) }
    )
}

@Composable
private fun WriteScreen(
    detail: String,
    impression: String,
    onDetailChanged: (String) -> Unit,
    onImpressionChanged: (String) -> Unit,
    onClickNavigationBack: () -> Unit,
    onClickSave: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column {
            LargeTopAppBar(
                title = { Text(stringResource(R.string.title_write_yumenomemo)) },
                navigationIcon = { NavigationBackIcon { onClickNavigationBack() } },
            )
            Spacer(modifier = Modifier.size(24.dp))
            FormField(
                value = detail,
                onValueChange = onDetailChanged,
                placeholder = stringResource(R.string.label_write_yumenomemo_detail),
            )
            FormField(
                value = impression,
                onValueChange = onImpressionChanged,
                placeholder = stringResource(R.string.label_write_yumenomemo_impression),
            )
            Spacer(modifier = Modifier.size(24.dp))
            FilledTonalButton(
                onClick = onClickSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(text = stringResource(R.string.button_write_yumenomemo))
            }
        }
    }
}

@Composable
fun FormField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
) {
    Box(
        Modifier
            .padding(horizontal = 24.dp)
            .height(48.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
        )
        if (value.isEmpty()) {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

package com.rmakiyama.yumenomemo.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.rmakiyama.yumenomemo.model.YumeId
import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.rmakiyama.yumenomemo.theme.YumenomemoTheme

@Composable
fun YumenomemoListView(
    list: List<Yumenomemo>
) {
    LazyColumn(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(list, key = { it.id.id }) { memo ->
            YumenomemoItemView(yumenomemo = memo)
        }
    }
}

@Composable
fun YumenomemoItemView(
    modifier: Modifier = Modifier,
    yumenomemo: Yumenomemo,
) {
    Surface(modifier = modifier) {
        Text(
            text = yumenomemo.detail,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun YumenomemoListViewPreview() {
    val list = listOf(
        Yumenomemo(YumeId(1), "hoge"),
        Yumenomemo(YumeId(1), "fuga"),
        Yumenomemo(YumeId(1), "piyo"),
    )
    YumenomemoTheme {
        YumenomemoListView(
            list = list,
        )
    }
}

package com.rmakiyama.yumenomemo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rmakiyama.yumenomemo.model.YumeId
import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.rmakiyama.yumenomemo.theme.YumenomemoTheme

@Composable
fun YumenomemoListView(
    list: List<Yumenomemo>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(),
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(12.dp),
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
    Surface(modifier = modifier.padding(horizontal = 24.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer),
        ) {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = yumenomemo.detail,
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.size(8.dp))
            if (yumenomemo.impression.isNotBlank()) {
                Text(
                    text = yumenomemo.impression,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.size(8.dp))
            }
            Text(
                text = yumenomemo.dreamedAt.toString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.6f),
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.size(16.dp))
        }
    }
}

@Preview
@Composable
fun YumenomemoListViewPreview() {
    val list = listOf(
        Yumenomemo(YumeId(1), "hoge", ""),
        Yumenomemo(YumeId(1), "fuga", ""),
        Yumenomemo(YumeId(1), "piyo", ""),
    )
    YumenomemoTheme {
        YumenomemoListView(
            list = list,
        )
    }
}

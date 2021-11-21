package com.rmakiyama.yumenomemo.home

import com.rmakiyama.yumenomemo.model.Yumenomemo

internal data class HomeViewState(
    val yumenomemoList: List<Yumenomemo>
) {
    companion object {
        val Empty = HomeViewState(
            yumenomemoList = emptyList(),
        )
    }
}

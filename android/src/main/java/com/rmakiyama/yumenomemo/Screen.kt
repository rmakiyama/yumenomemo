package com.rmakiyama.yumenomemo

import com.rmakiyama.yumenomemo.model.YumeId

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object YumenomemoDetail : Screen("yumenomemo/{yumeId}") {
        fun createRoute(yumeId: YumeId): String = "yumenomemo/${yumeId.id}"
    }
}

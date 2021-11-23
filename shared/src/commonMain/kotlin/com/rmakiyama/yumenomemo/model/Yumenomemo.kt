package com.rmakiyama.yumenomemo.model

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.jvm.JvmInline

@JvmInline
value class YumeId(val id: Int)

data class Yumenomemo(
    val id: YumeId,
    val detail: String,
    val impression: String,
) {
    val dreamedAt: LocalDateTime =
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
}

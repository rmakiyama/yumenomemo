package com.rmakiyama.yumenomemo.model

import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone.Companion.currentSystemDefault
import kotlinx.datetime.toLocalDateTime
import kotlin.jvm.JvmInline

@JvmInline
value class YumeId(val id: Int)

data class Yumenomemo(
    val id: YumeId,
    val detail: String,
    val impression: String,
    val dreamedAt: LocalDateTime = now().toLocalDateTime(currentSystemDefault())
)

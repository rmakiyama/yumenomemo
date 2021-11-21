package com.rmakiyama.yumenomemo.model

import kotlin.jvm.JvmInline

@JvmInline
value class YumeId(val id: Int)

data class Yumenomemo(
    val id: YumeId,
    val detail: String,
)

package com.rmakiyama.yumenomemo.datasource

import com.rmakiyama.yumenomemo.model.Yumenomemo

interface YumenomemoDataSource {

    suspend fun save(
        detail: String,
        impression: String,
    )

    suspend fun getAll(): List<Yumenomemo>
}

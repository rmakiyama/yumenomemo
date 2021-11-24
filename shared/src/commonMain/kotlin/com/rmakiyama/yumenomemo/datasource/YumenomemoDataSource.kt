package com.rmakiyama.yumenomemo.datasource

import com.rmakiyama.yumenomemo.model.Yumenomemo

interface YumenomemoDataSource {
    suspend fun getAll(): List<Yumenomemo>
}

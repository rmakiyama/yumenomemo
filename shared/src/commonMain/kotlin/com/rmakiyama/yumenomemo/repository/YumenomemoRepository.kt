package com.rmakiyama.yumenomemo.repository

import com.rmakiyama.yumenomemo.datasource.YumenomemoDataSource
import com.rmakiyama.yumenomemo.model.Yumenomemo

interface YumenomemoRepository {

    suspend fun save(
        detail: String,
        impression: String,
    )

    suspend fun getAll(): List<Yumenomemo>
}

internal class DefaultYumenomemoRepository(
    private val dataSource: YumenomemoDataSource,
) : YumenomemoRepository {

    override suspend fun save(
        detail: String,
        impression: String,
    ) {
        dataSource.save(detail, impression)
    }

    override suspend fun getAll(): List<Yumenomemo> {
        return dataSource.getAll()
    }
}

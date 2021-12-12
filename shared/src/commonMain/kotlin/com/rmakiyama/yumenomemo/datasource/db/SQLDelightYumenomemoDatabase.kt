package com.rmakiyama.yumenomemo.datasource.db

import com.rmakiyama.yumenomemo.datasource.YumenomemoDataSource
import com.rmakiyama.yumenomemo.db.YumenomemoDatabase
import com.rmakiyama.yumenomemo.model.YumeId
import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.squareup.sqldelight.db.SqlDriver
import kotlinx.datetime.Clock.System.now
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import com.rmakiyama.yumenomemo.db.Yumenomemo as YumenomemoEntity

internal class SQLDelightYumenomemoDatabase(driver: SqlDriver) : YumenomemoDataSource {

    private val queries = YumenomemoDatabase(driver).yumenomemoDatabaseQueries

    override suspend fun save(
        detail: String,
        impression: String,
    ) {
        queries.save(
            detail = detail,
            impression = impression,
            dreamed_at = now().toLocalDateTime(TimeZone.currentSystemDefault()).toString()
        )
    }

    override suspend fun getAll(): List<Yumenomemo> {
        return queries.selectAll().executeAsList().convert()
    }
}

private fun List<YumenomemoEntity>.convert(): List<Yumenomemo> {
    return map { entity -> entity.convert() }
}

private fun YumenomemoEntity.convert(): Yumenomemo {
    return Yumenomemo(
        id = YumeId(id = id),
        detail = detail,
        impression = impression,
        dreamedAt = LocalDateTime.parse(dreamed_at),
    )
}

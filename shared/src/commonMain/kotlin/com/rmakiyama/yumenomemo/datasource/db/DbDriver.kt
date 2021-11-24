package com.rmakiyama.yumenomemo.datasource.db

import com.rmakiyama.yumenomemo.core.Platform
import com.squareup.sqldelight.db.SqlDriver

internal expect class DbDriver(platform: Platform) {
    fun createSqlDriver(schema: SqlDriver.Schema, dbName: String): SqlDriver
}

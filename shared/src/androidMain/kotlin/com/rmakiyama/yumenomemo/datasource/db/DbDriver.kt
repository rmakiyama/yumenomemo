package com.rmakiyama.yumenomemo.datasource.db

import com.rmakiyama.yumenomemo.core.Platform
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

internal actual class DbDriver actual constructor(private val platform: Platform) {
    actual fun createSqlDriver(schema: SqlDriver.Schema, dbName: String): SqlDriver {
        return AndroidSqliteDriver(schema, platform.context, dbName)
    }
}

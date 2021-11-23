package com.rmakiyama.yumenomemo.datasource.db

import com.rmakiyama.yumenomemo.core.Platform
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

internal actual class DbDriver actual constructor(platform: Platform) {
    actual fun createSqlDriver(schema: SqlDriver.Schema, dbName: String): SqlDriver {
        return NativeSqliteDriver(schema, dbName)
    }
}

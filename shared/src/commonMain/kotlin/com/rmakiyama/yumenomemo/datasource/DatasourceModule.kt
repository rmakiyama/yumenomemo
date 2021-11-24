package com.rmakiyama.yumenomemo.datasource

import com.rmakiyama.yumenomemo.core.Platform
import com.rmakiyama.yumenomemo.datasource.db.DbDriver
import com.rmakiyama.yumenomemo.datasource.db.SQLDelightYumenomemoDatabase
import com.rmakiyama.yumenomemo.db.YumenomemoDatabase

class DatasourceModule {

    fun provideYumenomemoDatasource(platform: Platform): YumenomemoDataSource {
        return SQLDelightYumenomemoDatabase(
            driver = provideDbDriver(
                platform = platform,
            ).createSqlDriver(
                schema = YumenomemoDatabase.Schema,
                dbName = DATABASE_NAME,
            )
        )
    }

    private fun provideDbDriver(platform: Platform): DbDriver {
        return DbDriver(platform)
    }

    companion object {
        private const val DATABASE_NAME = "YumenomemoDatabase"
    }
}

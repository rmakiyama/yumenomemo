package com.rmakiyama.yumenomemo.di

import co.touchlab.kermit.Logger
import co.touchlab.kermit.platformLogWriter
import com.rmakiyama.yumenomemo.core.Platform
import com.rmakiyama.yumenomemo.datasource.DatasourceModule
import com.rmakiyama.yumenomemo.datasource.YumenomemoDataSource
import com.rmakiyama.yumenomemo.repository.DefaultYumenomemoRepository
import com.rmakiyama.yumenomemo.repository.YumenomemoRepository
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoList
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import com.rmakiyama.yumenomemo.usecase.WriteYumenomemo
import com.rmakiyama.yumenomemo.usecase.WriteYumenomemoUseCase

class SharedModule(val platform: Platform) {

    init {
        initLogger()
    }

    private val datasourceModule: DatasourceModule = DatasourceModule()

    private val yumenomemoDataSource: YumenomemoDataSource =
        datasourceModule.provideYumenomemoDatasource(platform)
    private val yumenomemoRepository: YumenomemoRepository = DefaultYumenomemoRepository(
        dataSource = yumenomemoDataSource,
    )

    val getYumenomemoList: GetYumenomemoListUseCase
        get() = GetYumenomemoList(repository = yumenomemoRepository)
    val writeYumenomemo: WriteYumenomemoUseCase
        get() = WriteYumenomemo(repository = yumenomemoRepository)

    private fun initLogger() {
        Logger.setTag("Yumenomemo")
        Logger.setLogWriters(platformLogWriter())
    }
}

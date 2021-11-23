package com.rmakiyama.yumenomemo.di

import com.rmakiyama.yumenomemo.core.Platform
import com.rmakiyama.yumenomemo.datasource.DatasourceModule
import com.rmakiyama.yumenomemo.datasource.YumenomemoDataSource
import com.rmakiyama.yumenomemo.repository.DefaultYumenomemoRepository
import com.rmakiyama.yumenomemo.repository.YumenomemoRepository
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoList
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase

class SharedModule(val platform: Platform) {

    private val datasourceModule: DatasourceModule = DatasourceModule()

    private val yumenomemoDataSource: YumenomemoDataSource =
        datasourceModule.provideYumenomemoDatasource(platform)
    private val yumenomemoRepository: YumenomemoRepository = DefaultYumenomemoRepository(
        dataSource = yumenomemoDataSource,
    )

    val getYumenomemoList: GetYumenomemoListUseCase
        get() = GetYumenomemoList(repository = yumenomemoRepository)
}

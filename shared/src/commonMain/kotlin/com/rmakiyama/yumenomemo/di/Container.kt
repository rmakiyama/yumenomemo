package com.rmakiyama.yumenomemo.di

import com.rmakiyama.yumenomemo.datasource.FakeYumenomemoDataSource
import com.rmakiyama.yumenomemo.datasource.YumenomemoDataSource
import com.rmakiyama.yumenomemo.repository.DefaultYumenomemoRepository
import com.rmakiyama.yumenomemo.repository.YumenomemoRepository
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoList
import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase

object Container {
    private val fakeYumenomemoDataSource: YumenomemoDataSource = FakeYumenomemoDataSource()
    private val yumenomemoRepository: YumenomemoRepository = DefaultYumenomemoRepository(
        dataSource = fakeYumenomemoDataSource
    )

    val getYumenomemoList: GetYumenomemoListUseCase
        get() = GetYumenomemoList(repository = yumenomemoRepository)
}

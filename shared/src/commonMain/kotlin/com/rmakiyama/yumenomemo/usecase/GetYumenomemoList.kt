package com.rmakiyama.yumenomemo.usecase

import com.rmakiyama.yumenomemo.model.Yumenomemo
import com.rmakiyama.yumenomemo.repository.YumenomemoRepository

interface GetYumenomemoListUseCase {
    suspend operator fun invoke(): List<Yumenomemo>
}

internal class GetYumenomemoList(
    private val repository: YumenomemoRepository,
) : GetYumenomemoListUseCase {
    override suspend fun invoke(): List<Yumenomemo> {
        return repository.getAll()
    }
}

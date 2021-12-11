package com.rmakiyama.yumenomemo.usecase

import com.rmakiyama.yumenomemo.repository.YumenomemoRepository

interface WriteYumenomemoUseCase {
    suspend operator fun invoke(params: Params)
    data class Params(
        val detail: String,
        val impression: String,
    )
}

internal class WriteYumenomemo(
    private val repository: YumenomemoRepository,
) : WriteYumenomemoUseCase {
    override suspend fun invoke(params: WriteYumenomemoUseCase.Params) {
        return repository.save(
            params.detail,
            params.impression,
        )
    }
}

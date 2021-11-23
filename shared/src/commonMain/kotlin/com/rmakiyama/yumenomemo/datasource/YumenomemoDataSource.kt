package com.rmakiyama.yumenomemo.datasource

import com.rmakiyama.yumenomemo.model.YumeId
import com.rmakiyama.yumenomemo.model.Yumenomemo
import kotlin.random.Random

interface YumenomemoDataSource {
    suspend fun getAll(): List<Yumenomemo>
}

internal class FakeYumenomemoDataSource : YumenomemoDataSource {
    override suspend fun getAll(): List<Yumenomemo> {
        return listOf(
            Yumenomemo(
                id = YumeId(Random.nextInt()),
                detail = getRandomString(),
                impression = getRandomString(),
            ),
            Yumenomemo(
                id = YumeId(Random.nextInt()),
                detail = getRandomString(),
                impression = getRandomString(),
            ),
            Yumenomemo(
                id = YumeId(Random.nextInt()),
                detail = getRandomString(),
                impression = getRandomString(),
            ),
            Yumenomemo(
                id = YumeId(Random.nextInt()),
                detail = getRandomString(),
                impression = getRandomString(),
            ),
            Yumenomemo(
                id = YumeId(Random.nextInt()),
                detail = getRandomString(),
                impression = getRandomString(),
            ),
        )
    }

    private fun getRandomString(min: Int = 30, max: Int = 120): String {
        val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        return (1..Random.nextInt(min, max))
            .map { charset.random() }
            .joinToString("")
    }
}

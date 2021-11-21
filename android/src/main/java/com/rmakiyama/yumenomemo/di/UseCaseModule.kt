package com.rmakiyama.yumenomemo.di

import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class UseCaseModule {

    @Provides
    fun provideGetYumenomemoList(): GetYumenomemoListUseCase {
        return Container.getYumenomemoList
    }
}

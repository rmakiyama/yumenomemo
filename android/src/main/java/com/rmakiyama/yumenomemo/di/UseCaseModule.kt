package com.rmakiyama.yumenomemo.di

import com.rmakiyama.yumenomemo.usecase.GetYumenomemoListUseCase
import com.rmakiyama.yumenomemo.usecase.WriteYumenomemoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal class UseCaseModule {

    @Provides
    fun provideGetYumenomemoList(sharedModule: SharedModule): GetYumenomemoListUseCase {
        return sharedModule.getYumenomemoList
    }

    @Provides
    fun provideWriteYumenomemo(sharedModule: SharedModule): WriteYumenomemoUseCase {
        return sharedModule.writeYumenomemo
    }
}

package com.rmakiyama.yumenomemo.di

import android.content.Context
import com.rmakiyama.yumenomemo.core.Platform
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class AppModule {

    @Provides
    @Singleton
    fun provideSharedModule(@ApplicationContext context: Context): SharedModule {
        return SharedModule(Platform(context = context))
    }
}

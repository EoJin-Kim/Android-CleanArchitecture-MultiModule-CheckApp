package com.ej.checkapp.di

import com.ej.data.repository.MainRepositoryImpl
import com.ej.data.repository.SplashRepositoryImpl
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.data.repository.remote.datasource.SplashDataSource
import com.ej.domain.repository.MainRepository
import com.ej.domain.repository.SplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ): MainRepository {
        return MainRepositoryImpl(mainDataSource)
    }

    @Singleton
    @Provides
    fun provideSplashRepository(
        splashDataSource: SplashDataSource
    ): SplashRepository {
        return SplashRepositoryImpl(splashDataSource)
    }
}
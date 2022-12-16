package com.ej.checkapp.di

import com.ej.data.repository.MainRepositoryImpl
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ): MainRepository {
        return MainRepositoryImpl(mainDataSource)
    }
}
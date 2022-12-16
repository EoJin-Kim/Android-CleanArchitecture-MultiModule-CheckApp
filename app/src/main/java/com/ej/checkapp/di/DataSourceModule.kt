package com.ej.checkapp.di

import com.ej.data.remote.api.LoveCalculatorApi
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.data.repository.remote.datasourceimpl.MainDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(loveCalculatorApi: LoveCalculatorApi): MainDataSource {
        return MainDataSourceImpl(loveCalculatorApi)
    }
}
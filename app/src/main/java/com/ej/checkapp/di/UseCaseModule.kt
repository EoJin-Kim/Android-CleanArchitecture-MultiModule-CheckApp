package com.ej.checkapp.di

import com.ej.domain.repository.MainRepository
import com.ej.domain.repository.SplashRepository
import com.ej.domain.usecase.CheckAppVersionUseCase
import com.ej.domain.usecase.CheckLoveCalcuratorUseCase
import com.ej.domain.usecase.GetStatisticsUseCase
import com.ej.domain.usecase.SetStatisticsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository: MainRepository): CheckLoveCalcuratorUseCase {
        return CheckLoveCalcuratorUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository: SplashRepository): CheckAppVersionUseCase {
        return CheckAppVersionUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository: MainRepository): GetStatisticsUseCase {
        return GetStatisticsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository: MainRepository): SetStatisticsUseCase {
        return SetStatisticsUseCase(repository)
    }
}
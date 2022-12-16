package com.ej.checkapp.di

import com.ej.domain.repository.MainRepository
import com.ej.domain.usecase.CheckLoveCalcuratorUseCase
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
}
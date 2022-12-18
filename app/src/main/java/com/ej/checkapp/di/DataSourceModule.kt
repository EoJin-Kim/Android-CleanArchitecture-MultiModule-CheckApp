package com.ej.checkapp.di

import com.ej.data.remote.api.LoveCalculatorApi
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.data.repository.remote.datasource.SplashDataSource
import com.ej.data.repository.remote.datasourceimpl.MainDataSourceImpl
import com.ej.data.repository.remote.datasourceimpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi,
        firebaseDatabase: FirebaseDatabase,
        firebaseFirestore: FirebaseFirestore
    ): MainDataSource {
        return MainDataSourceImpl(
            loveCalculatorApi,
            firebaseDatabase,
            firebaseFirestore,
        )
    }

    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseDatabase: FirebaseDatabase,
        firebaseFirestore: FirebaseFirestore
    ): SplashDataSource {
        return SplashDataSourceImpl(firebaseDatabase,firebaseFirestore)
    }
}
package com.ej.data.repository

import com.ej.data.repository.remote.datasource.SplashDataSource
import com.ej.domain.repository.SplashRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val spashDataSource: SplashDataSource
): SplashRepository{
    override fun checkAppVersion(): Task<DataSnapshot> {
        return spashDataSource.checkAppVersion()
    }
}
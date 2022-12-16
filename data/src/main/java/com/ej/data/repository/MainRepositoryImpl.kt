package com.ej.data.repository

import com.ej.data.mapper.MainMapper
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.repository.MainRepository
import com.ej.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
) : MainRepository{
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,

        host: String,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter,host, key, mName, wName))
    }
}
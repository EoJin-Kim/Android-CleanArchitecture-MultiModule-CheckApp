package com.ej.domain.repository

import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.utils.RemoteErrorEmitter

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ) : DomainLoveResponse?
}
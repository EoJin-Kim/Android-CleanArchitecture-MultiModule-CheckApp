package com.ej.domain.usecase

import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.repository.MainRepository
import com.ej.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class CheckLoveCalcuratorUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun excute(remoteErrorEmitter: RemoteErrorEmitter,
                       host: String,
                       key: String,
                       mName: String,
                       wName: String) : DomainLoveResponse?{
        return mainRepository.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName)
    }
}
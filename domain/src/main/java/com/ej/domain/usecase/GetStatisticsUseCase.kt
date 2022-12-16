package com.ej.domain.usecase

import com.ej.domain.repository.MainRepository
import javax.inject.Inject

class GetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun excute() = mainRepository.getStatistics()
}
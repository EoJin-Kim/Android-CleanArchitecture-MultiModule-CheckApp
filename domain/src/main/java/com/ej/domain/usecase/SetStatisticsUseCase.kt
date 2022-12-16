package com.ej.domain.usecase

import com.ej.domain.repository.MainRepository
import javax.inject.Inject

class SetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    fun excute(plusValue : Int) = mainRepository.setStatistics(plusValue)
}
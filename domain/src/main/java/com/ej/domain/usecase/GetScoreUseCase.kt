package com.ej.domain.usecase

import com.ej.domain.model.DomainScore
import com.ej.domain.repository.MainRepository
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val mainRepository : MainRepository
) {
    fun excute() = mainRepository.getScore()
}
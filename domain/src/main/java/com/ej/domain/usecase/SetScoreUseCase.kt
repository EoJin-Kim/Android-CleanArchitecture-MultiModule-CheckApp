package com.ej.domain.usecase

import com.ej.domain.model.DomainScore
import com.ej.domain.repository.MainRepository
import javax.inject.Inject

class SetScoreUseCase @Inject constructor(
    private val mainRepository : MainRepository
) {
    fun excute(score: DomainScore) = mainRepository.setScore(score)
}
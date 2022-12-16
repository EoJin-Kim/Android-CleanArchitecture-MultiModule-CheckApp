package com.ej.domain.usecase

import com.ej.domain.repository.SplashRepository
import javax.inject.Inject

class CheckAppVersionUseCase @Inject constructor(
    private val splashRepository: SplashRepository
) {
    fun execute() = splashRepository.checkAppVersion()
}
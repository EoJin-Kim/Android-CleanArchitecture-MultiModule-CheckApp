package com.ej.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ej.domain.usecase.CheckAppVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase,
) : ViewModel(){
    fun checkAppVersion() = checkAppVersionUseCase.execute()
}
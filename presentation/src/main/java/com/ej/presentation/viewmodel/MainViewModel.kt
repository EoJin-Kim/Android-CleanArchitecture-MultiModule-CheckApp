package com.ej.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.usecase.CheckLoveCalcuratorUseCase
import com.ej.domain.usecase.GetStatisticsUseCase
import com.ej.domain.usecase.SetStatisticsUseCase
import com.ej.domain.utils.ErrorType
import com.ej.domain.utils.RemoteErrorEmitter
import com.ej.domain.utils.ScreenState
import com.ej.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalcuratorUseCase: CheckLoveCalcuratorUseCase,
    private val setStatisticsUseCase: SetStatisticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
) : ViewModel(), RemoteErrorEmitter {

    private val _apiCallEvent = SingleLiveEvent<ScreenState>()
    val apiCallEvent: LiveData<ScreenState>
        get() = _apiCallEvent

    private val _getStatisticsEvent = SingleLiveEvent<Int>()
    val getStatisticsEvent : LiveData<Int>
        get() = _getStatisticsEvent



    var apiCallResult = DomainLoveResponse("","",0,"")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"

    fun checkLoveCalculator(
        host: String,
        key: String,
        mName: String,
        wName: String
    ){
        viewModelScope.launch {
            checkLoveCalcuratorUseCase.excute(this@MainViewModel, host, key, mName, wName).let { response ->
                if (response != null) {
                    apiCallResult = response
                    _apiCallEvent.postValue(ScreenState.LOADING)
                } else {
                    _apiCallEvent.postValue(ScreenState.ERROR)
                }
            }
        }
    }

    fun setStatistics(plusValue : Int) = setStatisticsUseCase.excute(plusValue)

    fun getStatistics() = getStatisticsUseCase.excute()

    fun getStatiscsDisplay() =  getStatisticsUseCase.excute()
        .addOnSuccessListener {
            _getStatisticsEvent.postValue(it.value.toString().toInt())
        }


    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}
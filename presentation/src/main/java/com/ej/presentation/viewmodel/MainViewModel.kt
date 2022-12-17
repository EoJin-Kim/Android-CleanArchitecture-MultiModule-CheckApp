package com.ej.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.model.DomainScore
import com.ej.domain.usecase.*
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
    private val setScoreUseCase: SetScoreUseCase,
    private val getScoreUseCase: GetScoreUseCase,
) : ViewModel(), RemoteErrorEmitter {

    private val _apiCallEvent = SingleLiveEvent<ScreenState>()
    val apiCallEvent: LiveData<ScreenState>
        get() = _apiCallEvent

    private val _getStatisticsEvent = SingleLiveEvent<Int>()
    val getStatisticsEvent : LiveData<Int>
        get() = _getStatisticsEvent

    private val _getScoreEvent = SingleLiveEvent<Int>()
    val getScoreEvent : LiveData<Int>
        get() = _getScoreEvent



    var apiCallResult = DomainLoveResponse("","",0,"")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"

    val scoreList = arrayListOf<DomainScore>()

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

    fun getScore() = getScoreUseCase.excute()
        .addOnSuccessListener { snapshot->
            scoreList.clear()
            for(item in snapshot){
                item.toObject(DomainScore::class.java).let {
                    scoreList.add(it!!)
                }
            }
            _getScoreEvent.call()
        }

    fun setScore(man : String, woman:String,percentage:Int,date : String){
        setScoreUseCase.excute(DomainScore(man,woman,percentage,date))
    }


    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}
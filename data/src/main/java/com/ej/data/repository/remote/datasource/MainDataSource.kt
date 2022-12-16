package com.ej.data.repository.remote.datasource

import com.ej.data.remote.model.DataLoveResponse
import com.ej.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key : String,
        // fName = 남자이름
        mName:String,
        // sName = 여자이름
        wName: String,
    ) : DataLoveResponse?

    // 통계 가져오기
    fun getStatistics() : Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue:Int) : Task<Void>

}
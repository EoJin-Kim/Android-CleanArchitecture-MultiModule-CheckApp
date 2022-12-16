package com.ej.data.repository.remote.datasource

import com.ej.data.remote.model.DataLoveResponse
import com.ej.domain.utils.RemoteErrorEmitter

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
}
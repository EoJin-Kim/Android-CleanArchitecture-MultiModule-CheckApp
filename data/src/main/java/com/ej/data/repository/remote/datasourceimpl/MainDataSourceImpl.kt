package com.ej.data.repository.remote.datasourceimpl

import com.ej.data.remote.api.LoveCalculatorApi
import com.ej.data.remote.model.DataLoveResponse
import com.ej.data.repository.remote.datasource.MainDataSource
import com.ej.data.utils.base.BaseDataSource
import com.ej.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi,
    private val firebaseDatabase: FirebaseDatabase,
    private val firestore: FirebaseFirestore

): BaseDataSource(),MainDataSource {
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ) : DataLoveResponse?{
        val body : DataLoveResponse? = safeApiCall(remoteErrorEmitter) {
            loveCalculatorApi.getPercentage(host = host, key = key, fName = mName, sName = wName)
        }?.body()
        return body
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return firebaseDatabase.reference.child("statistics").get()
    }

    override fun setStatistics(plusValue : Int): Task<Void> {
        return firebaseDatabase.reference.child("statistics").setValue(plusValue)
    }
}
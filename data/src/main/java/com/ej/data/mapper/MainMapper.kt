package com.ej.data.mapper

import com.ej.data.remote.model.DataLoveResponse
import com.ej.data.remote.model.DataScore
import com.ej.domain.model.DomainLoveResponse
import com.ej.domain.model.DomainScore

object MainMapper {
    fun loveMapper(
        dataResponse: DataLoveResponse?,
    ) : DomainLoveResponse?{
        if (dataResponse != null) {
            return DomainLoveResponse(
                fname = dataResponse.fname,
                sname = dataResponse.sname,
                percentage = dataResponse.percentage,
                result = dataResponse.result
            )
        }
        else {
            return dataResponse
        }
    }
    fun scoreMapper(
        domainScore: DomainScore
    ) : DataScore{
        return DataScore(
            man =  domainScore.man,
            woman = domainScore.woman,
            percentage = domainScore.percentage,
            date = domainScore.date
        )
    }

}
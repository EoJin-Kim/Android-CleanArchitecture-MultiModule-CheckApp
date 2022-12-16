package com.ej.data.mapper

import com.ej.data.remote.model.DataLoveResponse
import com.ej.domain.model.DomainLoveResponse

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

}
package com.ej.data.remote.model


import com.google.gson.annotations.SerializedName

data class DataLoveResponse(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    @SerializedName("percentage")
    val percentage: Int,
    @SerializedName("result")
    val result: String,

)
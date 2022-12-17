package com.ej.data.remote.model

data class DataScore(
    // 남자이름
    val man : String,
    val woman : String,
    val percentage : Int,
    val date : String

){
    constructor(): this("오류","오류",0,"오류")
}

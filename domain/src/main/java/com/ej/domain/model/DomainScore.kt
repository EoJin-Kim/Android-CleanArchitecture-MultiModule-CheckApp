package com.ej.domain.model

data class DomainScore(
    // 남자이름
    val man : String,
    val woman : String,
    val percentage : Int,
    val date : String
) {
    constructor(): this("오류","오류",0,"오류")
}

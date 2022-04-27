package com.hyunjine.personallotto.data.remote

data class LottoData(
    val bnusNo: Int,
    val drwNo: Int,
    val drwNoDate: String,
    val drwtNo1: String,
    val drwtNo2: String,
    val drwtNo3: String,
    val drwtNo4: String,
    val drwtNo5: String,
    val drwtNo6: String,
    val firstAccumamnt: Long,
    val firstPrzwnerCo: Int,
    val firstWinamnt: Long,
    val returnValue: String,
    val totSellamnt: String
)
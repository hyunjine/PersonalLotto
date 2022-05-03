package com.hyunjine.personallotto.data.remote

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LottoService {

    @GET("/common.do")
    suspend fun getLottoNumber(
        @Query("drwNo") drwNum: Int,
        @Query("method") method: String
    ): LottoData
}
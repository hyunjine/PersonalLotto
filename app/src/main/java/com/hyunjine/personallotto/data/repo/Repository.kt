package com.hyunjine.personallotto.data.repo

import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.data.remote.LottoService
import io.reactivex.Single
import retrofit2.Response

class Repository(private val service: LottoService) {

    suspend fun getLottoNumber(drwNo: Int): LottoData = service.getLottoNumber(drwNo, "getLottoNumber")
}
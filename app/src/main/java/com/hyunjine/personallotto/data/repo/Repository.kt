package com.hyunjine.personallotto.data.repo

import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.data.remote.LottoService
import io.reactivex.Single

class Repository(private val service: LottoService) {

    fun getLottoNumber(drwNo: Int): Single<LottoData> = service.getLottoNumber(drwNo, "getLottoNumber")
}
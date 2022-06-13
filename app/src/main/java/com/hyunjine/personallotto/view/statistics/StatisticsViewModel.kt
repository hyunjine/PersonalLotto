package com.hyunjine.personallotto.view.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.util.base.BaseViewModel


class StatisticsViewModel : BaseViewModel() {
    private val _currentRound = MutableLiveData<String>()
    val currentRound: LiveData<String>
        get() = _currentRound

    private val _data = MutableLiveData<LottoData>()
    val data: LiveData<LottoData>
        get() = _data

}
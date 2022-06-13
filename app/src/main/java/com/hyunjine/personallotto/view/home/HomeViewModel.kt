package com.hyunjine.personallotto.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.util.base.BaseViewModel
import com.hyunjine.personallotto.util.constant.TAG
import kotlinx.coroutines.*
import org.jsoup.Jsoup


class HomeViewModel(private val repository: Repository) : BaseViewModel() {
    private val _currentRound = MutableLiveData<String>()
    val currentRound: LiveData<String>
        get() = _currentRound

    private val _data = MutableLiveData<LottoData>()
    val data: LiveData<LottoData>
        get() = _data

    fun getCurrentLottoRound() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                val doc = Jsoup.connect("https://dhlottery.co.kr/common.do?method=main").get()
                val result = doc.select("#lottoDrwNo").text().toString()
                getLottoNumber(result.toInt())
                result
            }.onSuccess {
                _currentRound.postValue(it.plus("회"))
            }.onFailure {
                Log.d(TAG, "getCurrentLottoRound: fail")
            }
        }
    }

    private suspend fun getLottoNumber(currentRound: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                repository.getLottoNumber(currentRound)
            }.onSuccess {
                Log.d(TAG, "getLottoNumber: $it")
                _data.postValue(it)
            }.onFailure {
                Log.d(TAG, "getCurrentLottoRound: ${it.message}")
            }
        }
    }
}
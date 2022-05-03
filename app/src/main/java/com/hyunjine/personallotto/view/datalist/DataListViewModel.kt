package com.hyunjine.personallotto.view.datalist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.util.base.BaseViewModel
import com.hyunjine.personallotto.util.constant.TAG
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import org.jsoup.Jsoup
import org.w3c.dom.Document
import java.util.concurrent.TimeUnit


class DataListViewModel : BaseViewModel() {
    private val _currentRound = MutableLiveData<String>()
    val currentRound: LiveData<String>
        get() = _currentRound

    private val _data = MutableLiveData<LottoData>()
    val data: LiveData<LottoData>
        get() = _data

}
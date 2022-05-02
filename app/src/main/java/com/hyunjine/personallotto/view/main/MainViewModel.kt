package com.hyunjine.personallotto.view.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyunjine.personallotto.data.remote.LottoData
import com.hyunjine.personallotto.data.repo.Repository
import com.hyunjine.personallotto.util.base.BaseViewModel
import com.hyunjine.personallotto.util.constant.TAG
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainViewModel(private val repository: Repository): BaseViewModel() {
    private val _data = MutableLiveData<LottoData>()
    val data: LiveData<LottoData>
        get() = _data

    fun getLottoNumber() {
        addDisposable(repository.getLottoNumber(1012)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        _data.postValue(it)
                        Log.d(TAG, "getLottoNumber: ${it.drwtNo1}")
                    },
                    {

                    }
                )
        )
    }

}
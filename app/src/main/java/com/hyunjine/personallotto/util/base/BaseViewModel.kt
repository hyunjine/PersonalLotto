package com.hyunjine.personallotto.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel: ViewModel() {
//    protected val _viewEvent: MutableLiveData<St> by lazy { MutableLiveData() }
//    val viewEvent: LiveData<U>
//        get() = _viewEvent

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}
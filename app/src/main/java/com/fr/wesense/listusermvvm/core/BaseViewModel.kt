package com.fr.wesense.listusermvvm.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected var compositeDisposable = CompositeDisposable()
    val liveError = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        disposComposite()
    }

    protected fun disposComposite() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
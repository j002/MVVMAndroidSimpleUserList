package com.fr.wesense.listusermvvm.api

import android.annotation.SuppressLint
import com.fr.wesense.listusermvvm.models.ResponseUserList
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class UserApiServiceImpl @Inject constructor(retrofit: Retrofit) : UserApiService {
    private var userApi: UserApi = retrofit.create(UserApi::class.java)

    @SuppressLint("CheckResult")
    override fun users(): Single<ResponseUserList> = Single.create { emitter ->
        userApi.run {
            userList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                    onError = { error ->

                        emitter.onError(error)
                    },
                    onSuccess = { response ->
                        if (response.isSuccessful) {
                            emitter.onSuccess(response.body()!!)
                        }
                    }
                )
        }
    }
}


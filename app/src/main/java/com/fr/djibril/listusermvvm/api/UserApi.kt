package com.fr.djibril.listusermvvm.api

import com.fr.djibril.listusermvvm.models.ResponseUserList
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("HSzRBp/users")
    fun userList(): Single<Response<ResponseUserList>>
}
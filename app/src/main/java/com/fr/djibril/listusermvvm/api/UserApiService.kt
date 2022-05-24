package com.fr.djibril.listusermvvm.api

import com.fr.djibril.listusermvvm.models.ResponseUserList
import io.reactivex.Single

interface UserApiService {

    fun users(): Single<ResponseUserList>
}
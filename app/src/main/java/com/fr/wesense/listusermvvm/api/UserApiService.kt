package com.fr.wesense.listusermvvm.api

import com.fr.wesense.listusermvvm.models.ResponseUserList
import io.reactivex.Single

interface UserApiService {

    fun users(): Single<ResponseUserList>
}
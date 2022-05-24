package com.fr.djibril.listusermvvm.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fr.djibril.listusermvvm.api.UserApiService
import com.fr.djibril.listusermvvm.core.BaseViewModel
import com.fr.djibril.listusermvvm.models.ResponseUserList
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ListUserViewModel @Inject constructor(
    private val userApiService: UserApiService
) : BaseViewModel() {

    private val liveUsers = MutableLiveData<ResponseUserList>()

    fun onUsersLoad(): LiveData<ResponseUserList> {
        return liveUsers
    }

    fun getUsers() {
        userApiService.run {
            users().subscribeBy(
                onSuccess = { response ->
                    liveUsers.postValue(response)
                },
                onError = { error ->
                    liveError.value = error.localizedMessage
                }
            )
        }
    }
}
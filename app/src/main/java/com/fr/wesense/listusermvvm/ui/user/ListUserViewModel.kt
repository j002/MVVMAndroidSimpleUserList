package com.fr.wesense.listusermvvm.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fr.wesense.listusermvvm.api.UserApiService
import com.fr.wesense.listusermvvm.core.BaseViewModel
import com.fr.wesense.listusermvvm.models.ResponseUserList
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ListUserViewModel @Inject constructor(private val userApiService: UserApiService) :
    BaseViewModel() {

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
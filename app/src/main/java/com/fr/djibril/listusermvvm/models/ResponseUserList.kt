package com.fr.djibril.listusermvvm.models

import com.squareup.moshi.Json

data class ResponseUserList(

    @field:Json(name = "ResponseUserList")
    val responseUserList: List<ResponseUserListItem?>? = null
)

data class ResponseUserListItem(

    @field:Json(name = "isOld")
    val isOld: Boolean? = null,

    @field:Json(name = "jobTitle")
    val jobTitle: String? = null,

    @field:Json(name = "name")
    val name: String? = null,

    @field:Json(name = "id")
    val id: Int? = null,

    @field:Json(name = "age")
    val age: Int? = null
)

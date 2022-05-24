package com.fr.wesense.listusermvvm.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fr.wesense.listusermvvm.R
import com.fr.wesense.listusermvvm.di.GlobalInjectorModule
import com.fr.wesense.listusermvvm.ui.user.adapter.UserListAdapter
import com.fr.wesense.listusermvvm.ui.user.di.DaggerListUserActivityComponent
import kotlinx.android.synthetic.main.activity_list_user.*
import javax.inject.Inject


class ListUserActivity : AppCompatActivity(R.layout.activity_list_user) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var listUserViewModel: ListUserViewModel
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerListUserActivityComponent
            .builder()
            .globalInjectorModule(GlobalInjectorModule(this))
            .build()
            .inject(this)

        listUserViewModel = ViewModelProvider(this, viewModelFactory).get(ListUserViewModel::class.java)

        listUserViewModel.getUsers()

        userListAdapter = UserListAdapter(listOf(), this)

        rv_users.adapter = userListAdapter

        listUserViewModel.onUsersLoad().observe(this) { users ->
            userListAdapter.setList(users.responseUserList)
        }
    }
}
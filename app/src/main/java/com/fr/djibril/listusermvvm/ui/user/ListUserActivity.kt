package com.fr.djibril.listusermvvm.ui.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fr.djibril.listusermvvm.R
import com.fr.djibril.listusermvvm.di.GlobalInjectorModule
import com.fr.djibril.listusermvvm.ui.user.adapter.UserListAdapter
import com.fr.djibril.listusermvvm.ui.user.di.DaggerListUserActivityComponent
import javax.inject.Inject

class ListUserActivity : AppCompatActivity(R.layout.activity_list_user) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var listUserViewModel: ListUserViewModel
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var rvUSer: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerListUserActivityComponent
            .builder()
            .globalInjectorModule(GlobalInjectorModule(this))
            .build()
            .inject(this)

        listUserViewModel = ViewModelProvider(this, viewModelFactory).get(ListUserViewModel::class.java)

        rvUSer = findViewById(R.id.rv_users)

        userListAdapter = UserListAdapter(listOf(), this)

        rvUSer.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvUSer.adapter = userListAdapter

        listUserViewModel.onUsersLoad().observe(this) { users ->
            userListAdapter.setList(users.responseUserList)
        }
    }

    override fun onResume() {
        super.onResume()
        listUserViewModel.getUsers()
    }
}
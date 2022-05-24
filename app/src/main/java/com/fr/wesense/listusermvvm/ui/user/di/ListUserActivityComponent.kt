package com.fr.wesense.listusermvvm.ui.user.di

import com.fr.wesense.listusermvvm.di.GlobalInjectorModule
import com.fr.wesense.listusermvvm.di.ViewModelModule
import com.fr.wesense.listusermvvm.ui.user.ListUserActivity
import dagger.Component

@Component(modules = [GlobalInjectorModule::class, ViewModelModule::class])
interface ListUserActivityComponent {
    fun inject(homeClientActivity: ListUserActivity)
}
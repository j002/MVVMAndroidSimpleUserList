package com.fr.djibril.listusermvvm.ui.user.di

import com.fr.djibril.listusermvvm.di.GlobalInjectorModule
import com.fr.djibril.listusermvvm.di.ViewModelModule
import com.fr.djibril.listusermvvm.ui.user.ListUserActivity
import dagger.Component

@Component(modules = [GlobalInjectorModule::class, ViewModelModule::class])
interface ListUserActivityComponent {
    fun inject(homeClientActivity: ListUserActivity)
}
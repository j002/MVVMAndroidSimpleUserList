package com.fr.wesense.listusermvvm.di

import com.fr.wesense.listusermvvm.App
import dagger.Component

@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(application: App)
}
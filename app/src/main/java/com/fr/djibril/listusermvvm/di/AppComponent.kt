package com.fr.djibril.listusermvvm.di

import com.fr.djibril.listusermvvm.App
import dagger.Component

@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun inject(application: App)
}
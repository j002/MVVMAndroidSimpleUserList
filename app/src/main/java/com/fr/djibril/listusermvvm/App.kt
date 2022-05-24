package com.fr.djibril.listusermvvm

import android.app.Application
import com.fr.djibril.listusermvvm.di.AppModule
import com.fr.djibril.listusermvvm.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }
}

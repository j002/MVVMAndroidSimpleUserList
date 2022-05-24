package com.fr.wesense.listusermvvm

import android.app.Application
import com.fr.wesense.listusermvvm.di.AppModule
import com.fr.wesense.listusermvvm.di.DaggerAppComponent

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

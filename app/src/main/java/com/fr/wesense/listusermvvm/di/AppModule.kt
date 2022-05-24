package com.fr.wesense.listusermvvm.di

import android.content.Context
import com.fr.wesense.listusermvvm.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: App) {

    @Provides
    fun provideApplicationContext(): Context = application
}
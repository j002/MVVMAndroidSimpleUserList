package com.fr.djibril.listusermvvm.di

import android.content.Context
import com.fr.djibril.listusermvvm.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: App) {

    @Provides
    fun provideApplicationContext(): Context = application
}
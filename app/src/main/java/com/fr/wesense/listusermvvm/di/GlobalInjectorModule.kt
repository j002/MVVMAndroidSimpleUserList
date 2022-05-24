package com.fr.wesense.listusermvvm.di

import android.app.Activity
import android.content.Context
import com.fr.wesense.listusermvvm.App
import com.fr.wesense.listusermvvm.Constants.Companion.ENDPOINT
import com.fr.wesense.listusermvvm.api.UserApiService
import com.fr.wesense.listusermvvm.api.UserApiServiceImpl
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class GlobalInjectorModule(var activity: Activity) {

    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideApplication(): App = activity.application as App

    @Provides
    fun provideUserApiService(service: UserApiServiceImpl): UserApiService = service

    @Provides
    fun provideRetrofit(): Retrofit {
        val moshi = Moshi.Builder()
            .build()
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(provideOkHttpClient())
            .baseUrl(ENDPOINT)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS)
        okhttpClientBuilder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .build()
            val response = chain.proceed(request)

            response
        }

        return okhttpClientBuilder.build()
    }
}
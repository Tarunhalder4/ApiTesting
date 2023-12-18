package com.example.apitesting

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class Mudule {

    /////////////     https://run.mocky.io/v3/db9421b8-df8d-4371-b352-517d530b765b
    @Provides
    @Singleton
    fun getBaseUrl():String =
        "https://run.mocky.io/v3/"


    @Provides
    @Singleton
    fun getRetrofit(baseUrl:String):Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }
    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
}
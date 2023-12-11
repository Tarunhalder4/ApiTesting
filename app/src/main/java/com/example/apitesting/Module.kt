package com.example.apitesting

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class Module {
    @Provides
    fun getBaseURL()="https://jsonplaceholder.typicode.com/"

    @Provides
    fun getRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun getService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}
package com.example.apitesting

import retrofit2.http.POST

interface ApiService {


    @POST("db9421b8-df8d-4371-b352-517d530b765b")
    suspend fun getData():Images
}
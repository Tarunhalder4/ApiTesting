package com.example.apitesting

import com.example.apitesting.model.Book
import com.example.apitesting.model.Status
import com.example.apitesting.model.Token
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    companion object{
        var token = ""
    }

    @GET("/status")
    fun getStatus():Call<Status>

    @GET("/books")
    fun getBookList():Call<List<Book>>

    @POST("/api-clients/")
    fun getToken(@Body requestBody: RequestBody):Call<Token>

//    @POST("")
//    @Headers({"Authorization", "Bearer $token" })
//    fun postBookOrder()





}
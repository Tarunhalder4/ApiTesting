package com.example.apitesting

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService){

    suspend fun getPost()=
        flow {
            emit(apiService.getPost())
        }.flowOn(Dispatchers.IO)

}
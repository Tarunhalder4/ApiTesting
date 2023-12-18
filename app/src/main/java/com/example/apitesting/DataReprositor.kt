package com.example.apitesting

import android.util.Log
import javax.inject.Inject

class DataReprositor @Inject constructor(private val apiService: ApiService) {

    //var data:MutableStateFlow<Images>? = null

//    val data: MutableStateFlow<Images>?
//        get() = _data

    suspend fun getData():Images{
      //  GlobalScope.launch {
            Log.d("tarun", "getData: ${apiService.getData().images}")
             return apiService.getData()
      //  }

    }





}
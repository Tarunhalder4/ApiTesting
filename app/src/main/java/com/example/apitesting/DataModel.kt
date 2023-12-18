package com.example.apitesting

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataModel @Inject constructor(private val reprositor: DataReprositor):ViewModel() {


    lateinit var data: MutableLiveData<Images>
    fun getData() {
        viewModelScope.launch{
            data.value =  reprositor.getData()
            Log.d("sameer", "getData456: " +  reprositor.getData().images.size)
            Log.d("sameer", "getData457: " +  data.value?.images?.size)

            //Log.d(TAG, "getData: ")
//            reprositor.data?.collect {
//                data = it.images
//                Log.d("tarun", "getData123: ${data?.size}")
//                Log.d("tarun", "getData123: ${ reprositor.getData()}")
//            }

        }


    }



}
package com.example.apitesting

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataModel @Inject constructor(private val reprositor: DataReprositor):ViewModel() {


    var data: MutableLiveData<Images> = MutableLiveData()
    fun getData() {
        viewModelScope.launch{
            data.value =  reprositor.getData()
        }


    }



}
package com.example.apitesting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _stateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
    val stateFlow: StateFlow<ApiState> =  _stateFlow

    fun getPost()= viewModelScope.launch {
            repository.getPost().catch {
                _stateFlow.value = ApiState.Error(it.message.toString())
            }.collect{
                _stateFlow.value = ApiState.Success(it)
            }
        }


}
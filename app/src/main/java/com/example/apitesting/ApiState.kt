package com.example.apitesting

sealed class ApiState{
    object Loading:ApiState()
    class Success<T>(val data:T):ApiState()
    class Error(val massage:String):ApiState()
    object Empty : ApiState()

}

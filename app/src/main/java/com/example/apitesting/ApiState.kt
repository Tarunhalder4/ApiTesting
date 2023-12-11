package com.example.apitesting

sealed class ApiState{
    object Loading:ApiState()
    class Success(val posts:List<Post>):ApiState()
    class Error(val massage:String):ApiState()
    object Empty : ApiState()

}

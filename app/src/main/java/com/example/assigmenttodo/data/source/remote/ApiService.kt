package com.example.assigmenttodo.data.source.remote

import com.example.assigmenttodo.data.model.Task
import retrofit2.Response
import retrofit2.http.GET


interface ApiService{

    @GET("todos")
    suspend fun getTasks(): Response<List<Task>>

}
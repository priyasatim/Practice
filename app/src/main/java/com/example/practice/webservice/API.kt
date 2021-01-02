package com.example.practice.webservice

import com.example.practice.model.User
import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("posts")
    fun getList(): Call<List<User>>
}
package com.example.chatwiseassement.network

import com.example.chatwiseassement.model.User
import retrofit2.Call
import retrofit2.http.GET



const val BASE_URL="https://jsonplaceholder.typicode.com/"
interface ApiServices {

    @GET("photos")
    fun getMovie(): Call<User>
}
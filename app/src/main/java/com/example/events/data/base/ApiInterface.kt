package com.example.events.data.base

import com.example.events.domain.EventsItem
import com.example.events.domain.User
import com.example.events.domain.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @GET("events")
    fun getData(): Call<List<EventsItem>>

    @POST("peoples")
    @Headers("Accept/application/json", "Content-Type:application/json")
    fun createUser(@Body params: User): Call<UserResponse>
}
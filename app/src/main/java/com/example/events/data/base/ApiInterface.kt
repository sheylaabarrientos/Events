package com.example.events.data.base

import com.example.events.domain.EventsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("events")
    fun getData(): Call<List<EventsItem>>
}
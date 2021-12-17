package com.example.events.data.remotesource

import com.example.events.data.model.ResponseEvents
import io.reactivex.Single
import retrofit2.http.GET

interface EventsRemoteSource {
    @GET("eventos")
    fun getEvents(): Single<ResponseEvents>

//        @POST("api/{checkin}")
//        fun postCheckIn(@Path("movie_id") movieId: Int): Single<MovieInfoResponse>
}

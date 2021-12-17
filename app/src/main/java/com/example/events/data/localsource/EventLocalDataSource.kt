package com.example.events.data.localsource

import com.example.events.data.model.EventsResponse
import io.reactivex.Single

interface EventLocalDataSource {
    fun addToCheckIn(movie: EventsResponse): Single<List<EventsResponse>>
    fun removeFavoriteMovieCheckIn(movie: EventsResponse): Single<List<EventsResponse>>
    fun getEvents(): Single<List<EventsResponse>>
}

package com.example.events.data.localsource

import com.example.events.data.model.EventsResponse
import io.reactivex.Single
import java.lang.IllegalStateException

object EventLocalDataSourceImpl : EventLocalDataSource {
    private val eventsList = mutableListOf<EventsResponse>()

    override fun addToCheckIn(event: EventsResponse): Single<List<EventsResponse>> {
        return Single.create { emitter ->
            val result = eventsList.add(event)
            if (result) {
                emitter.onSuccess(eventsList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun removeFavoriteMovieCheckIn(event: EventsResponse): Single<List<EventsResponse>> {
        return Single.create { emitter ->
            val checkInToRemove = eventsList.find {
                it.eventId == event.eventId
            }
            val result = eventsList.remove(checkInToRemove)
            if (result) {
                emitter.onSuccess(eventsList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun getEvents(): Single<List<EventsResponse>> {
        return Single.create { emitter ->
            emitter.onSuccess(eventsList)
        }
    }
}

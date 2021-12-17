package com.example.events.data.repository

import com.example.events.data.base.Network
import com.example.events.data.localsource.EventLocalDataSourceImpl
import com.example.events.data.mappers.EventMappers
import com.example.events.data.remotesource.EventsRemoteSource
import com.example.events.domain.Events
import io.reactivex.Single

class EventsRepositoryImpl : EventsRepository {
    private val eventsRemoteSource: EventsRemoteSource = Network.getEventsRemoteSource()
    private val eventLocalDataSource = EventLocalDataSourceImpl
    private val eventMapper = EventMappers()

    override fun getEvents(): Single<List<Events>> {
        return eventsRemoteSource
            .getEvents()
            .flatMap { eventResponseList ->
                eventLocalDataSource
                    .getEvents()
                    .map { favoriteMovieList ->
                        eventResponseList.eventsResults.forEach { eventResponse ->
                            val result = favoriteMovieList.any { favoriteEvent ->
                                favoriteEvent.eventId == eventResponse.eventId
                            }
                            eventResponse.isFavorite = result
                        }
                        eventResponseList.eventsResults
                    }
            }
            .map {
                eventMapper.map(it)
            }
    }
}

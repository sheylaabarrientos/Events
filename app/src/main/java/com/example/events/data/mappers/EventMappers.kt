package com.example.events.data.mappers

import com.example.events.data.model.EventsResponse
import com.example.events.domain.Events

class EventMappers {
    fun map(movieResponseList: List<EventsResponse>): List<Events> {
        val events = mutableListOf<Events>()
        movieResponseList.forEach {
            val event = Events(
                eventId = it.eventId,
                name = it.name,
                email = it.email,
            )
            events.add(event)
        }
        return events
    }
}
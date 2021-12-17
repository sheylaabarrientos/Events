package com.example.events.domain

import com.example.events.data.repository.EventsRepositoryImpl

class EventUseCase(private val eventsRepository: EventsRepositoryImpl = EventsRepositoryImpl()) {
    fun getEvent() = eventsRepository.getEvents()
//    fun addToCheckIn(event: Events) = eventsRepository.addToCheckIn(event)
//    fun removeToCheckIn(event: Events) = eventsRepository.removeToCheckIn(event)
}
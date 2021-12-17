package com.example.events.data.repository

import com.example.events.domain.Events
import io.reactivex.Single

interface EventsRepository {
    fun getEvents(): Single<List<Events>>
}

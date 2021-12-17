package com.example.events.data.model

import com.google.gson.annotations.SerializedName

data class ResponseEvents(
    @SerializedName("results")
    val eventsResults: List<EventsResponse>
)

package com.example.events.data.model

import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("id")
    val eventId: Int,
    @SerializedName("poster_path")
    val name: String? = null,
    @SerializedName("title")
    val email: String? = null,
    var isFavorite: Boolean = false,
)

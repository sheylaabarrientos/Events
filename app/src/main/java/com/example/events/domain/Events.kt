package com.example.events.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
        val eventId: Int,
        val name: String? = null,
        val email: String? = null,
) : Parcelable
package com.example.events.domain

data class UserResponse(
    val code: String?,
    val meta: String?,
    val data: User?,
)
package com.example.events.domain

class User(
    val id: String?,
    val name: String,
    val email: String?,
)

data class UserResponse(
    val id: String?,
    val people: User?
)

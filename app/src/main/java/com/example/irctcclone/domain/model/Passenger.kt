package com.example.irctcclone.domain.model

data class Passenger(
    val name: String,
    val age: Int,
    val gender: Gender,
    val berthPreference: BerthPreference?,
    val seatNumber: String? = null
)
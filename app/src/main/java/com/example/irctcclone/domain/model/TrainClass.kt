package com.example.irctcclone.domain.model

data class TrainClass(
    val classCode: String, // 1A, 2A, 3A, SL, etc.
    val className: String, // First AC, Second AC, etc.
    val fare: Double,
    val availableSeats: Int
)
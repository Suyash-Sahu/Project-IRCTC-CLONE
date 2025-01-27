package com.example.irctcclone.domain.model
data class Booking(
    val pnr: String,
    val trainNumber: String,
    val trainName: String,
    val journeyDate: String,
    val source: String,
    val destination: String,
    val passengers: List<Passenger>,
    val status: BookingStatus,
    val classCode: String,
    val totalFare: Double
)
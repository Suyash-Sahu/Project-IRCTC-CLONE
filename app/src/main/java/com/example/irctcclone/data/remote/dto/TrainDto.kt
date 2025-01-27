package com.example.irctcclone.data.remote.dto

data class TrainDto(
    val trainNumber: String,
    val trainName: String,
    val source: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String
)
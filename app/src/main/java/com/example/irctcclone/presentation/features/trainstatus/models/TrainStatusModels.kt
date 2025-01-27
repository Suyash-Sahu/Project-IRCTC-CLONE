package com.example.irctcclone.presentation.features.trainstatus.models

data class TrainStatus(
    val trainNumber: String,
    val trainName: String,
    val currentStation: String,
    val nextStation: String,
    val status: String,
    val schedule: List<Schedule>
)

data class Schedule(
    val stationName: String,
    val arrivalTime: String,
    val departureTime: String,
    val status: String
)
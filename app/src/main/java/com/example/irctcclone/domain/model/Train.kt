
package com.example.irctcclone.domain.model

data class Train(
    val trainNumber: String,
    val trainName: String,
    val source: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val availableClasses: List<TrainClass>,
    val runningDays: List<String>
)
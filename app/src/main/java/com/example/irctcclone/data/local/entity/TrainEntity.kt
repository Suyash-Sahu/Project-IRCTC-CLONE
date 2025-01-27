package com.example.irctcclone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trains")
data class TrainEntity(
    @PrimaryKey val trainNumber: String,
    val trainName: String,
    val source: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String
)
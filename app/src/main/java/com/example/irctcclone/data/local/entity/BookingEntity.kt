package com.example.irctcclone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookings")
data class BookingEntity(
    @PrimaryKey val pnr: String,
    val userId: String,
    val trainNumber: String,
    val journeyDate: String,
    val status: String
)
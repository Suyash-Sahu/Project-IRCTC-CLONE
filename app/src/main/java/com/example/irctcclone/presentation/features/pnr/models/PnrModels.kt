package com.example.irctcclone.presentation.features.pnr.models

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irctcclone.R

data class PnrStatus(
    val pnrNumber: String,
    val trainNumber: String,
    val trainName: String,
    val journeyDate: String,
    val fromStation: String,
    val toStation: String,
    val passengers: List<PassengerStatus>
)

data class PassengerStatus(
    val passengerNumber: String,
    val bookingStatus: String,
    val currentStatus: String
)

data class RecentPNR(
    val pnrNumber: String,
    val trainNumber: String,
    val trainName: String,
    val journeyDate: String
)
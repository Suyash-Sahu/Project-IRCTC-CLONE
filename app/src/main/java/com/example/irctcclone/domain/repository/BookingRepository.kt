package com.example.irctcclone.domain.repository

import com.example.irctcclone.domain.model.Booking
import com.example.irctcclone.utils.Result

interface BookingRepository {
    suspend fun createBooking(booking: Booking): Result<String>
    suspend fun getBooking(pnr: String): Result<Booking>
    suspend fun cancelBooking(pnr: String): Result<Boolean>
    suspend fun getUserBookings(userId: String): Result<List<Booking>>
}
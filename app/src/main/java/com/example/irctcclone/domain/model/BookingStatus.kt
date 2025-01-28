package com.example.irctcclone.domain.model

enum class BookingStatus {
    CONFIRMED,
    WAITLISTED,
    RAC,        // Reservation Against Cancellation
    CANCELLED,
    PENDING
}

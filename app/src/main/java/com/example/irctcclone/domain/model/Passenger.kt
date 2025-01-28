package com.example.irctcclone.domain.model

import com.example.irctcclone.domain.model.enums.BerthPreference
import com.example.irctcclone.domain.model.enums.Gender

data class Passenger(
    val name: String,
    val age: Int,
    val gender: Gender,
    val berthPreference: BerthPreference? = null
)
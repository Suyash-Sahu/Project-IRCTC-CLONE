package com.example.irctcclone.domain.repository

import com.example.irctcclone.domain.model.Train
import com.example.irctcclone.utils.Result

interface TrainRepository {
    suspend fun searchTrains(from: String, to: String, date: String): Result<List<Train>>
    suspend fun getTrainDetails(trainNumber: String): Result<Train>
    suspend fun checkAvailability(trainNumber: String, classCode: String, date: String): Result<Int>
}
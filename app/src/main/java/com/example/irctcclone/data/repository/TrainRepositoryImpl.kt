package com.example.irctcclone.data.repository

import com.example.irctcclone.data.remote.api.TrainApiService
import com.example.irctcclone.domain.model.Train
import com.example.irctcclone.domain.repository.TrainRepository
import com.example.irctcclone.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrainRepositoryImpl @Inject constructor(
    private val trainApiService: TrainApiService
) : TrainRepository {

    override suspend fun searchTrains(from: String, to: String, date: String): Result<List<Train>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = trainApiService.searchTrains(from, to, date)
                val trains = response.map { dto ->
                    Train(
                        trainNumber = dto.trainNumber,
                        trainName = dto.trainName,
                        source = dto.source,
                        destination = dto.destination,
                        departureTime = dto.departureTime,
                        arrivalTime = dto.arrivalTime,
                        duration = dto.duration
                    )
                }
                Result.Success(trains)
            } catch (e: Exception) {
                Result.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}
package com.example.irctcclone.data.repository

import com.example.irctcclone.data.remote.api.TrainApiService
import com.example.irctcclone.di.ServiceLocator
import com.example.irctcclone.domain.model.Train
import com.example.irctcclone.domain.model.TrainClass
import com.example.irctcclone.domain.repository.TrainRepository
import com.example.irctcclone.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TrainRepositoryImpl : TrainRepository {
    private val trainApiService: TrainApiService = ServiceLocator.provideTrainApiService()

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
                        duration = dto.duration,
                        availableClasses = getDummyClasses(),
                        runningDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                    )
                }
                Result.Success(trains)
            } catch (e: Exception) {
                Result.Error(e.message ?: "An unknown error occurred")
            }
        }
    }

    override suspend fun getTrainDetails(trainNumber: String): Result<Train> {
        return withContext(Dispatchers.IO) {
            try {
                // For now, return dummy data
                val dummyTrain = Train(
                    trainNumber = trainNumber,
                    trainName = "Sample Train",
                    source = "Delhi",
                    destination = "Mumbai",
                    departureTime = "10:00 AM",
                    arrivalTime = "8:00 PM",
                    duration = "10h 0m",
                    availableClasses = getDummyClasses(),
                    runningDays = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
                )
                Result.Success(dummyTrain)
            } catch (e: Exception) {
                Result.Error(e.message ?: "An unknown error occurred")
            }
        }
    }

    override suspend fun checkAvailability(trainNumber: String, classCode: String, date: String): Result<Int> {
        return withContext(Dispatchers.IO) {
            try {
                // For now, return dummy availability data
                val dummyAvailability = 42 // Random number of available seats
                Result.Success(dummyAvailability)
            } catch (e: Exception) {
                Result.Error(e.message ?: "An unknown error occurred")
            }
        }
    }

    private fun getDummyClasses(): List<TrainClass> {
        return listOf(
            TrainClass(
                classCode = "1A",
                className = "First AC",
                fare = 2500.0,
                availableSeats = 20
            ),
            TrainClass(
                classCode = "2A",
                className = "Second AC",
                fare = 1500.0,
                availableSeats = 30
            ),
            TrainClass(
                classCode = "3A",
                className = "Third AC",
                fare = 1000.0,
                availableSeats = 40
            ),
            TrainClass(
                classCode = "SL",
                className = "Sleeper",
                fare = 500.0,
                availableSeats = 60
            )
        )
    }
}
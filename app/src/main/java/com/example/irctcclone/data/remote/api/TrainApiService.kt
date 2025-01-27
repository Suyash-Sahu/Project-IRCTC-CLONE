package com.example.irctcclone.data.remote.api

import com.example.irctcclone.data.remote.dto.TrainDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainApiService {
    @GET("trains/search")
    suspend fun searchTrains(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("date") date: String
    ): List<TrainDto>
}
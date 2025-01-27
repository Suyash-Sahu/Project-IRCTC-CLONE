package com.example.irctcclone.domain.usecase

import com.example.irctcclone.domain.model.Train
import com.example.irctcclone.domain.repository.TrainRepository
import com.example.irctcclone.utils.Result

class SearchTrainsUseCase(private val trainRepository: TrainRepository) {
    suspend operator fun invoke(from: String, to: String, date: String): Result<List<Train>> {
        return trainRepository.searchTrains(from, to, date)
    }
}
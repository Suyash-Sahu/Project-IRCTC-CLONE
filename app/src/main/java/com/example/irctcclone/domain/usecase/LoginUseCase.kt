package com.example.irctcclone.domain.usecase

import com.example.irctcclone.domain.model.User
import com.example.irctcclone.domain.repository.AuthRepository
import com.example.irctcclone.utils.Result

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): Result<User> {
        return authRepository.login(username, password)
    }
}
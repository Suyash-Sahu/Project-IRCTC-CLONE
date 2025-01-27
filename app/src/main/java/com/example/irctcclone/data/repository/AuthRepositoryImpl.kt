package com.example.irctcclone.data.repository

import com.example.irctcclone.domain.model.User
import com.example.irctcclone.domain.repository.AuthRepository
import com.example.irctcclone.utils.Result

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(username: String, password: String): Result<User> {
        // Implement login logic using remote data source
    }

    override suspend fun register(user: User, password: String): Result<User> {
        // Implement registration logic
    }

    override suspend fun forgotPassword(email: String): Result<Boolean> {
        // Implement forgot password logic
    }
}
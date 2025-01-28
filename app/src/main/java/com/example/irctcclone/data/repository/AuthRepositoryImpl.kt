package com.example.irctcclone.data.repository

import com.example.irctcclone.domain.model.User
import com.example.irctcclone.domain.repository.AuthRepository
import com.example.irctcclone.utils.Result

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(username: String, password: String): Result<User> {
        // TODO: Implement login logic using remote data source
        return Result.Error("Not implemented yet")
    }

    override suspend fun register(user: User, password: String): Result<User> {
        // TODO: Implement registration logic
        return Result.Error("Not implemented yet")
    }

    override suspend fun forgotPassword(email: String): Result<Boolean> {
        // TODO: Implement forgot password logic
        return Result.Error("Not implemented yet")
    }
}
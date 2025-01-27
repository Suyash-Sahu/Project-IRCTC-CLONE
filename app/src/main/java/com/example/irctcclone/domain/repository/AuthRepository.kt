package com.example.irctcclone.domain.repository

import com.example.irctcclone.domain.model.User
import com.example.irctcclone.utils.Result

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<User>
    suspend fun register(user: User, password: String): Result<User>
    suspend fun forgotPassword(email: String): Result<Boolean>
}
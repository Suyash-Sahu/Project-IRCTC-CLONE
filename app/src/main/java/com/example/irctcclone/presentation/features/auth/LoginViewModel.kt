package com.example.irctcclone.presentation.features.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irctcclone.domain.usecase.LoginUseCase
import com.example.irctcclone.utils.Result
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = loginUseCase(username, password)
            when (result) {
                is Result.Success -> {
                    // Handle successful login
                }
                is Result.Error -> {
                    // Handle login error
                }
            }
        }
    }
}
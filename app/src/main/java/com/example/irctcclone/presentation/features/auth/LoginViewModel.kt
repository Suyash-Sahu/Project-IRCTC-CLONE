package com.example.irctcclone.presentation.features.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.irctcclone.domain.model.User
import com.example.irctcclone.domain.usecase.LoginUseCase
import com.example.irctcclone.utils.Result
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginState = MutableLiveData<Result<User>>()
    val loginState: LiveData<Result<User>> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Result.Loading
            val result = loginUseCase(username, password)
            _loginState.value = result
            when (result) {
                is Result.Success -> {
                    // Handle successful login
                }
                is Result.Error -> {
                    // Handle login error
                }
                is Result.Loading -> {
                    // Handle loading state
                }
            }
        }
    }
}
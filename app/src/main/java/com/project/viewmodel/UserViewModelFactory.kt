package com.project.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.model.remote.service.TokenService

class UserViewModelFactory(private val tokenService: TokenService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // UserViewModel 클래스와 일치하는 경우 반환
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(tokenService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

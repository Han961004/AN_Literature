package com.project.view.main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.model.remote.service.TokenService

class MainViewModelFactory(private val tokenService: TokenService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // MainViewModel 클래스와 일치하는 경우 반환
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(tokenService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

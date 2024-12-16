package com.project.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.data.models.UserCreate
import com.project.data.api.RetrofitBuilder
import kotlinx.coroutines.launch

class AccountsSignViewModel : ViewModel() {

    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> get() = _signUpSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun signUp(email: String, password: String, nickname: String) {
        val request = UserCreate(email, password, nickname)

        viewModelScope.launch {
            try {
                val response = RetrofitBuilder.apiHelper.userCreate(request)
                if (response.isSuccessful) {
                    _signUpSuccess.value = true
                } else {
                    val errorBody = response.errorBody()?.string()
                    _errorMessage.value = "Sign up failed: ${response.code()}, Error: ${errorBody ?: "No error body"}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Sign up error: ${e.message}"
                Log.e("testt", "Sign up error", e)
            }
        }
    }
}

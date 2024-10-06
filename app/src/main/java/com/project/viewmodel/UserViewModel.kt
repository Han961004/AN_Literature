package com.project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.model.remote.service.TokenService
import com.project.model.remote.dataclass.UserResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import android.util.Log

class UserViewModel(private val tokenService: TokenService) : ViewModel() {

    // 유저 정보를 저장하는 LiveData
    private val _userInfo = MutableLiveData<UserResponse>()
    val userInfo: LiveData<UserResponse> get() = _userInfo

    // 유저 정보를 가져오는 함수
    fun getUserInfo(token: String) {
        viewModelScope.launch {
            try {
                // JWT 토큰을 Authorization 헤더에 포함하여 요청
                val response: Response<UserResponse> = tokenService.getUserInfo("Bearer $token")
                if (response.isSuccessful) {
                    _userInfo.value = response.body()  // 성공 시 유저 정보 업데이트
                } else {
                    Log.e("UserViewModel", "Error: ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("UserViewModel", "Exception: ${e.message}")
            }
        }
    }
}

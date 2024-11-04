// SignUpViewModel.kt
package com.project.view.sign.up

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.model.remote.dataclass.LocalSignUpRequest
import com.project.util.RetrofitClient
import kotlinx.coroutines.launch


/*
* ViewModel는 데이터 저장소 및 비즈니스 로직을 담당하여 UI에서 필요한 데이터를 제공하는 역할을 합니다.
* ViewModel은 Activity와 Fragment가 참조할 수 있는 데이터와 로직을 관리합니다.
 */

class SignUpViewModel : ViewModel() {

    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> get() = _signUpSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage


    /*
    *
     */
    fun signUp(username: String, password: String) {
        val request = LocalSignUpRequest(username, password, email = "")

        Log.d("testt", "회원가입 요청 시작: $request")

        viewModelScope.launch {
            try {
                val response = RetrofitClient.signService.localSignUpRequest(request)
                if (response.isSuccessful) {
                    _signUpSuccess.value = true
                    Log.d("testt", "회원가입 요청 성공")
                } else {
                    _errorMessage.value = "회원가입 실패: ${response.code()}"
                    Log.e("testt", "회원가입 실패: 코드 ${response.code()}, 메시지 ${response.message()}")
                }
            } catch (e: Exception) {
                _errorMessage.value = "회원가입 요청 실패: ${e.message}"
                Log.e("testt", "회원가입 요청 실패", e)
            }
        }

    }
}

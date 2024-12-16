package com.project.ui.view.accounts.create

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.models.remote.dataclass.CommonSignUpRequest
import com.project.util.RetrofitClient
import kotlinx.coroutines.launch


/*
* ViewModel는 데이터 저장소 및 비즈니스 로직을 담당하여 UI에서 필요한 데이터를 제공하는 역할을 합니다.
* ViewModel은 Activity와 Fragment가 참조할 수 있는 데이터와 로직을 관리합니다.
 */

class CommonSignUpViewModel : ViewModel() {

    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> get() = _signUpSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    /*
    * 회원가입 요청
    */
    fun signUp(username: String, email: String, password: String, nickname: String) {
        val request = CommonSignUpRequest(
            username = username,
            email = email,
            password = password,
            nickname = nickname,
            platform = "local" // 기본값으로 설정
        )

        Log.d("testt", "회원가입 요청 시작: $request")

        viewModelScope.launch {
            try {
                val response = RetrofitClient.signService.commonSignUp(request)
                if (response.isSuccessful) {
                    _signUpSuccess.value = true
                    Log.d("testt", "회원가입 요청 성공")
                } else {
                    val errorBody = response.errorBody()?.string()
                    _errorMessage.value = "회원가입 실패: ${response.code()}, 오류 내용: ${errorBody ?: "오류 본문 없음"}"
                    Log.e("testt", "회원가입 실패: 코드 ${response.code()}, 메시지 ${response.message()}, 오류 내용: $errorBody")
                }
            } catch (e: Exception) {
                _errorMessage.value = "회원가입 요청 실패: ${e.message}"
                Log.e("testt", "회원가입 요청 실패", e)
            }
        }
    }
}

// SignUpViewModel.kt
package com.project.view.sign.up

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.model.remote.dataclass.SignUpRequest
import com.project.util.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {

    private val _signUpSuccess = MutableLiveData<Boolean>()
    val signUpSuccess: LiveData<Boolean> get() = _signUpSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun signUp(username: String, password: String) {
        val request = SignUpRequest(username, password)

        Log.d("testt", "회원가입 요청 시작: $request")

        RetrofitClient.signService.signUp(request).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    _signUpSuccess.value = true
                    Log.d("testt", "회원가입 요청 성공")
                } else {
                    _errorMessage.value = "회원가입 실패: ${response.code()}"
                    Log.e("testt", "회원가입 실패: 코드 ${response.code()}, 메시지 ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                _errorMessage.value = "회원가입 요청 실패: ${t.message}"
                Log.e("testt", "회원가입 요청 실패", t)
            }
        })
    }
}

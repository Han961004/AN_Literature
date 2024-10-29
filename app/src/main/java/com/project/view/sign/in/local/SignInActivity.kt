package com.project.view.sign.`in`.local

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.databinding.ActivitySignInBinding
import com.project.util.RetrofitClient
import com.project.model.remote.dataclass.SignInRequest
import com.project.model.remote.dataclass.SignInResponse
import com.project.view.main.MainActivity
import com.project.view.sign.up.SignUpActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener { handleLocalLogin() }
        binding.btnSignup.setOnClickListener { handleSignUp() }
//        binding.btnKakaoLogin.setOnClickListener { handleKakaoLogin() }
        binding.btnNaverLogin.setOnClickListener {  }
    }

    // 회원가입 페이지로 이동
    private fun handleSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    // 로컬 로그인 처리
    private fun handleLocalLogin() {
        val id = binding.etId.text.toString()
        val password = binding.etPassword.text.toString()

        if (id.isNotEmpty() && password.isNotEmpty()) {
            login(id, password)
        } else {
            Toast.makeText(this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun login(id: String, password: String) {
        val request = SignInRequest(id, password)

        RetrofitClient.signService.signIn(request).enqueue(object : Callback<SignInResponse> {
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                try {
                    if (response.isSuccessful) {
                        Log.d("testt", "응답 성공: ${response.code()}")

                        // Authorization 헤더에서 전체 Bearer 토큰을 그대로 가져옴
                        val authorizationHeader = response.headers()["Authorization"]
                        Log.d("testt", "Authorization 헤더: $authorizationHeader")

                        if (!authorizationHeader.isNullOrEmpty()) {
                            val intent = Intent(this@SignInActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                            Log.d("testt", "로그인 성공! JWT 토큰: $authorizationHeader")
                        } else {
                            Log.d("testt", "로그인 실패: Authorization 헤더를 받지 못했습니다.")
                        }
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.d("testt", "로그인 실패: ${response.code()}, 오류 내용: ${errorBody ?: "오류 본문 없음"}")
                    }
                } catch (e: Exception) {
                    Log.e("testt", "응답 처리 중 오류 발생", e)
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Log.d("testt", "로그인 요청 실패: ${t.message}")
            }
        })
    }





//    // 카카오 로그인 처리
//    private fun handleKakaoLogin() {
//        KakaoSdk.init(this, getString(R.string.kakao_api_key))
//
//        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
//            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
//                if (error != null) {
//                    Log.d("testt", "카카오톡으로 로그인 실패! " + error.message)
//
//                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) { return@loginWithKakaoTalk }
//                    loginWithKakaoAccount()
//                } else if (token != null) {
//                    val intent = Intent(this, LoadingActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                    Log.d("testt", "카카오톡으로 로그인 성공! " + token.accessToken)
//                }
//            }
//        } else {
//            loginWithKakaoAccount()
//        }
//    }
//
//    private fun loginWithKakaoAccount() {
//        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
//            if (error != null) {
//                Log.d("testt", "카카오 계정으로 로그인 실패! " + error.message)
//            } else if (token != null) {
//                // 카카오 계정 로그인 성공 시 토큰 저장
//                saveAccessToken(token.accessToken)
//
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//                Log.d("testt", "카카오 계정으로 로그인 성공! " + token.accessToken)
//            }
//        }
//        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
//    }
//
//    private fun saveAccessToken(token: String) {
//        val sharedPreferences = getSharedPreferences("auth", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putString("jwt_token", token)
//        editor.apply()
//    }

}

package com.project.view.sign.`in`

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.user.UserApiClient
import com.project.databinding.ActivitySignInBinding
import com.project.model.remote.dataclass.LocalSignInRequest
import com.project.util.RetrofitClient
import com.project.view.main.MainActivity
import com.project.view.main.MainViewModel
import com.project.view.sign.up.SignUpActivity
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocalSignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener { handleLocalLogin() }
        binding.btnSignup.setOnClickListener { handleSignUp() }
        binding.btnKakaoLogin.setOnClickListener { handleKakaoLogin() }
        binding.btnNaverLogin.setOnClickListener {  }
    }

    /* 회원 가입
    * 회원 가입 액티비티 이동
     */
    private fun handleSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    /* 로컬 로그인 요청
    * 아이디, 패스워드 빈 값이면 안되고,
    * 응답이 정상적으로 왔으면, Response 값을 MainViewModel 에 저장후, MainActivity 이동
     */
    private fun handleLocalLogin() {
        val id = binding.etId.text.toString()
        val password = binding.etPassword.text.toString()

        if (id.isNotEmpty() && password.isNotEmpty()) {
            lifecycleScope.launch {
                try {
                    val request = LocalSignInRequest(id, password)
                    val response = RetrofitClient.signService.localSignInRequest(request)

                    if (response.isSuccessful) {
                        val username = response.body()?.username
                        if (username != null) {
                            Log.d("testt", "응답 성공: ${response.code()}, 사용자 이름: $username")
                            mainViewModel.setUserInfo(username)
                            val intent = Intent(this@LocalSignInActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Log.e("testt", "응답 본문이 null입니다.")
                        }
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.d("testt", "로그인 실패: ${response.code()}, 오류 내용: ${errorBody ?: "오류 본문 없음"}")
                    }
                } catch (e: Exception) {
                    Log.e("testt", "로그인 중 오류 발생", e)
                }
            }

        } else {
            Toast.makeText(this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
        }
    }

    /* 카카오 로그인 요청
    * 카카오 서버로 부터 AccessToken 을 받으면, 헤더에 넣어서 서비스 서버로 보낸다.
    * 서비스 서버는 받은 액세스 토큰을 헤더에서 꺼내서 가공하고, JWT 와 유저 정보를 넣어서 클라이언트로 보낸다.
    * 클라이언트는 서비스 서버로 부터 받은 JWT 와 유저 정보를 MainViewModel 에 저장한 다음, MainActivity 로 이동한다.
     */
    private fun handleKakaoLogin() {
        KakaoSdk.init(this, "87106be7a6e3deb75c6beb7382dbd684")
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("testt", "Login failed: ${error.message}")
            } else if (token != null) {
                Log.d("testt", "Login successful, token: ${token.accessToken}")
                lifecycleScope.launch {
                    try {
                        val response = RetrofitClient.signService.kakaoSignInRequest(token.accessToken)
                        if (response.isSuccessful) {
                            val jwtToken = response.headers()["Authorization"]
                            if (jwtToken != null) {
                                mainViewModel.setUserInfo(jwtToken)
                                val intent = Intent(this@LocalSignInActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Log.e("testt", "JWT token not found in headers")
                            }
                        } else {
                            Log.e("testt", "Backend login failed: ${response.code()}")
                        }
                    } catch (e: Exception) {
                        Log.e("testt", "Backend login error: ${e.message}")
                    }
                }
            }
        }
        UserApiClient.instance.run {
            if (isKakaoTalkLoginAvailable(this@LocalSignInActivity)) {
                loginWithKakaoTalk(this@LocalSignInActivity, callback = callback)
            } else {
                loginWithKakaoAccount(this@LocalSignInActivity, callback = callback)
            }
        }
    }
}

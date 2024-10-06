package com.project.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.databinding.ActivitySignupBinding
import com.project.model.remote.RetrofitClient
import com.project.model.remote.dataclass.SignUpRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        signUpBtn()
    }

    private fun signUpBtn() {
        binding.buttonSignUp.setOnClickListener {
            val id = binding.editTextId.text.toString()
            val nickname = binding.editTextNickname.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextConfirmPassword.text.toString()

            if (id.isNotEmpty() && nickname.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    signUp(id, email, password, nickname)
                } else {
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "모든 필드를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signUp(id: String, email: String, password: String, nickname: String) {

        val request = SignUpRequest(id, email, password, nickname)

        RetrofitClient.signService.signUp(request).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@SignUpActivity, "회원가입 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // 서버에서 오류 반환 시
                    Toast.makeText(
                        this@SignUpActivity, "회원가입 실패: ${response.code()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                // 네트워크 요청 실패 시
                Toast.makeText(this@SignUpActivity, "회원가입 요청 실패: ${t.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}

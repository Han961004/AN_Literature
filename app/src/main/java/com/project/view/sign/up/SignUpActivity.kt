// SignUpActivity.kt
package com.project.view.sign.up

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.project.databinding.ActivitySignUpBinding
import com.project.view.main.MainActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObservers()
        signUpBtn()
    }

    private fun setUpObservers() {
        viewModel.signUpSuccess.observe(this, Observer { success ->
            if (success) {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                Log.d("testt", "회원가입 성공")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Log.e("testt", "회원가입 실패: $message")
        })
    }

    private fun signUpBtn() {
        binding.buttonSignUp.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            Log.d("testt", "입력된 username: $username, password: $password")

            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.signUp(username, password)
            } else {
                Toast.makeText(this, "모든 필드를 입력하세요.", Toast.LENGTH_SHORT).show()
                Log.w("testt", "모든 필드가 입력되지 않음")
            }
        }
    }
}

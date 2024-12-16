package com.project.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.project.databinding.ActivitySignUpBinding
import com.project.ui.viewmodel.AccountsSignViewModel

class AccountsSignActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: AccountsSignViewModel by viewModels()

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
                Toast.makeText(this, "회원 가입 성공", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, AccountsLoginActivity::class.java))
                finish()
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Log.e("testt", "회원 가입 실패: $message")
        })
    }

    private fun signUpBtn() {
        binding.buttonSignUp.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val nickname = binding.editTextNickname.text.toString()

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && nickname.isNotEmpty()) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "유효하지 않은 이메일", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.signUp(email, password, nickname)
                }
            } else {
                Toast.makeText(this, "모든 필드 채우기", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

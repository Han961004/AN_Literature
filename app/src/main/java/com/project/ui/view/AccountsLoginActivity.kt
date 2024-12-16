package com.project.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.project.databinding.ActivitySignInBinding
import com.project.data.api.AccountsService
import com.project.data.api.RetrofitBuilder
import com.project.data.models.Login
import kotlinx.coroutines.launch

class AccountsLoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnLogin.setOnClickListener { handleLogin() }
        binding.btnSignup.setOnClickListener { handleSign() }
    }

    private fun handleSign() {
        val intent = Intent(this, AccountsSignActivity::class.java)
        startActivity(intent)
    }

    private fun handleLogin() {
        val username = binding.etId.text.toString() // -> email 교체
        val password = binding.etPassword.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()) {
            lifecycleScope.launch {
                try {
                    val request = Login(username, password)
                    val response = RetrofitBuilder.apiHelper.login(request)

                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            Log.d("testt", "Login successful: ${responseBody.token}")
//                            mainViewModel.setUserInfo(responseBody.user.email, responseBody.jwt)
//
//                            val intent = Intent(this@AccountsLoginActivity, MainActivity::class.java)
//                            startActivity(intent)
//                            finish()
                        } else {
                            Log.e("testt", "Response body is null")
                        }
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.d("testt", "Login failed: ${response.code()}, Error: ${errorBody ?: "No error body"}")
                    }
                } catch (e: Exception) {
                    Log.e("testt", "Login error", e)
                }
            }
        } else {
            Toast.makeText(this, "Please enter username and password.", Toast.LENGTH_SHORT).show()
        }
    }
}

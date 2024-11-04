package com.project.view.sign

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.databinding.ActivitySignSplashBinding
import com.project.view.sign.`in`.LocalSignInActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Splash 화면
        * 2초 동안 Activity 정지 하다가 로그인 Activity 이동
        * 이미지 변경 -> .gif 이미지 가능 ?
         */
        GlobalScope.launch {
            delay(2000)
            startActivity(Intent(this@SplashActivity, LocalSignInActivity::class.java))
            finish()
        }
    }
}

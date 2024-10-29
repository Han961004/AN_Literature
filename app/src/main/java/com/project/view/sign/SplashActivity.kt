//package com.project.view.activity
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.project.databinding.ActivitySplashBinding
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//class SplashActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivitySplashBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivitySplashBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        GlobalScope.launch {
//            delay(2000)
//            startActivity(Intent(this@SplashActivity, SignInActivity::class.java))
//            finish()
//        }
//    }
//}

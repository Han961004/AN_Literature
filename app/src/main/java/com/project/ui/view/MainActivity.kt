//package com.project.ui.view
//
//import android.os.Bundle
//import android.util.Log
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import com.project.R
//import com.project.databinding.ActivityMainBinding
//import com.project.ui.viewmodel.MainViewModel
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private val mainViewModel: MainViewModel by viewModels()
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // NavBar의 사용자 정보 업데이트
//        mainViewModel.userDetails.observe(this) { userDetails ->
//            userDetails?.let {
//                val headerView = binding.navigationView.getHeaderView(0)
//                val userNameTextView = headerView.findViewById<TextView>(R.id.textViewNickname)
//
//                // 사용자 이름 업데이트
//                userNameTextView.text = it.name
//                Log.d("testt", "NavBar username updated to: ${it.name}")
//            } ?: run {
//                Log.e("testt", "userDetails is null")
//            }
//        }
//
//
//
//
//        // init Default Fragment
//        if (savedInstanceState == null)
//            supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, MainHomeFragment()).commit()
//
//
//
//
//
//        /* nav bar
//        * MainHomeFrg
//        * PostListFrg
//        * FeedListFrg
//        * StatisticsAct 통계
//        * SettingAct
//        * Logout Request */
//        binding.apply {
//            toolbar.setNavigationOnClickListener {
//                drawerLayout.open()
//            }
//
//            navigationView.setNavigationItemSelectedListener { menuItem ->
//                menuItem.isChecked = true
//
//                when (menuItem.itemId) {
//                    R.id.nav_home_frg -> {
//                        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, MainHomeFragment()).commit()
//
//                    }
//                    R.id.nav_postList_act -> {
//
//                    }
//
//                    R.id.nav_feedbackList_act -> {
//
//                    }
//
//                    R.id.nav_statistics_act -> {
//                        Toast.makeText(this@MainActivity, "통계 화면", Toast.LENGTH_SHORT).show()
//                    }
//                    R.id.nav_setting_act -> {
//                        Toast.makeText(this@MainActivity, "설정 화면", Toast.LENGTH_SHORT).show()
//                    }
//                    R.id.nav_logout_request -> {
//                        Toast.makeText(this@MainActivity, "로그 아웃 요청", Toast.LENGTH_SHORT).show()
//                        requestsLogout()
//                    }
//                }
//
//                drawerLayout.close()
//                true
//            }
//        }
//    }
//
//
//    private fun requestsLogout() {
////        // SharedPreferences 등을 사용해 토큰 제거 (로그인 상태 해제)
////        val sharedPreferences = getSharedPreferences("your_app_prefs", MODE_PRIVATE)
////        sharedPreferences.edit().clear().apply()
////
////        val intent = Intent(this, AccountsLoginActivity::class.java)
////        startActivity(intent)
////        finish()
//    }
//}

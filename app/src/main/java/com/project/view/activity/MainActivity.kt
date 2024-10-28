package com.project.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.project.R
import com.project.databinding.ActivityMainBinding
import com.project.model.remote.RetrofitClient
import com.project.model.remote.dataclass.UserDetailResponse
import com.project.util.UserInfo
import com.project.view.fragment.MainHomeFragment
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userInfo : UserInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // NavigationView에서 헤더 뷰 가져오기
        val headerView = binding.navigationView.getHeaderView(0) // 첫 번째 헤더를 가져옴
        userInfo = UserInfo(headerView) // UserInfo 인스턴스 생성, 헤더뷰 참조

        // init Default Fragment
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, MainHomeFragment()).commit()

        // 사용자 ID 설정 (예: 1번 사용자)
        val userId = 1



        /* 최초 정보 받기
        * nav bar의 닉네임, 현재 쓴 포스트 갯수
        * HomeFrg 공지나 달력 및 오늘의 글감 등
        * PostListFrg 포스트들 최초 20개 -> 무한 스크롤
        * FeedListFrg 요청들 최초 20개 -> 무한 스크롤
        *  */
        lifecycleScope.launch {
            try {
                val response: Response<UserDetailResponse> = RetrofitClient.signService.getUserDetails(userId)
                if (response.isSuccessful) {
                    val userDetail = response.body()
                    userDetail?.let {
                        userInfo.setUserInfo(it.nickname, it.postCount)
                    }
                } else {
                    Log.e("testt", "HTTP Error: ${response.code()} - ${response.errorBody()?.string()}")
                    Toast.makeText(this@MainActivity, "사용자 정보를 가져오지 못했습니다. (HTTP 오류)", Toast.LENGTH_SHORT).show()
                    userInfo.resetUserInfo()
                }
            } catch (e: HttpException) {
                Log.e("testt", "HTTP Exception: ${e.code()} - ${e.message()}")
                Toast.makeText(this@MainActivity, "서버 응답 중 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                Log.e("testt", "Network Error: ${e.localizedMessage}")
                Toast.makeText(this@MainActivity, "네트워크 오류가 발생했습니다. 인터넷 연결을 확인하세요.", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("testt", "Unknown Error: ${e.localizedMessage}")
                e.printStackTrace() // 예외의 전체 스택 트레이스를 출력
                Toast.makeText(this@MainActivity, "알 수 없는 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            }
        }




        /* nav bar
        * MainHomeFrg
        * PostListFrg
        * FeedListFrg
        * StatisticsAct 통계
        * SettingAct
        * Logout Request */
        binding.apply {
            toolbar.setNavigationOnClickListener {
                drawerLayout.open()
            }

            navigationView.setNavigationItemSelectedListener { menuItem ->
                menuItem.isChecked = true

                when (menuItem.itemId) {
                    R.id.nav_home_frg -> {
                        supportFragmentManager.beginTransaction().replace(binding.fragmentContainer.id, MainHomeFragment()).commit()

                    }
                    R.id.nav_postList_act -> {
                        val intent = Intent(this@MainActivity, PostListActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.nav_feedbackList_act -> {
                        val intent = Intent(this@MainActivity, FeedbackActivity::class.java)
                        startActivity(intent)
                    }

                    R.id.nav_statistics_act -> {
                        Toast.makeText(this@MainActivity, "통계 화면", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_setting_act -> {
                        Toast.makeText(this@MainActivity, "설정 화면", Toast.LENGTH_SHORT).show()
                    }
                    R.id.nav_logout_request -> {
                        Toast.makeText(this@MainActivity, "로그 아웃 요청", Toast.LENGTH_SHORT).show()
                        requestsLogout()
                    }
                }

                drawerLayout.close()
                true
            }
        }
    }


    private fun requestsLogout() {
//        // SharedPreferences 등을 사용해 토큰 제거 (로그인 상태 해제)
//        val sharedPreferences = getSharedPreferences("your_app_prefs", MODE_PRIVATE)
//        sharedPreferences.edit().clear().apply()
//
//        val intent = Intent(this, SignInActivity::class.java)
//        startActivity(intent)
//        finish()
    }
}

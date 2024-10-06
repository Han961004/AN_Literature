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

        // 사용자 ID 설정 (예: 1번 사용자)
        val userId = 1

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


        // 기본 Fragment 설정
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MainHomeFragment())
                .commit()
        }

        binding.apply {
            toolbar.setNavigationOnClickListener {
                drawerLayout.open()
            }

            navigationView.setNavigationItemSelectedListener { menuItem ->
                menuItem.isChecked = true
                Log.d("testt", "Menu item selected: ${menuItem.itemId}")

                when (menuItem.itemId) {
                    R.id.nav_home -> {
                        Toast.makeText(this@MainActivity, "홈", Toast.LENGTH_SHORT).show()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, MainHomeFragment())
                            .commit()
                        Log.d("testt", "MainHomeFragment loaded")
                    }
                    R.id.nav_write -> {
                        Toast.makeText(this@MainActivity, "글쓰기", Toast.LENGTH_SHORT).show()
                        // PostsWriteActivity로 이동
                        val intent = Intent(this@MainActivity, PostWriteActivity::class.java)
                        startActivity(intent)
                        Log.d("testt", "Navigating to PostWriteActivity")
                    }
                    R.id.nav_posts_detail -> {
                        val intent = Intent(this@MainActivity, PostDetailActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.nav_menu_logout -> {
                        // 로그아웃 처리
                        performLogout()
                    }
                }
                // Drawer를 닫기
                drawerLayout.close()
                true
            }
        }
    }

    private fun performLogout() {
        // SharedPreferences 등을 사용해 토큰 제거 (로그인 상태 해제)
        val sharedPreferences = getSharedPreferences("your_app_prefs", MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()

        // 로그인 화면으로 이동
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish() // 현재 Activity 종료
    }
}

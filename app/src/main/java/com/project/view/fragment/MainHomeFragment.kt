package com.project.view.fragment

import android.util.Log  // 로그를 사용하려면 이 임포트를 추가
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.project.R
import com.project.model.remote.RetrofitClient
import com.project.viewmodel.UserViewModel
import com.project.viewmodel.UserViewModelFactory

class MainHomeFragment : Fragment() {

    // UserViewModel을 Fragment에서 사용할 수 있도록 설정
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(RetrofitClient.tokenService)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // JWT 토큰을 가져옴 (이 부분은 로그인 후 저장된 토큰을 사용해야 함)
        val token = "your_jwt_token_here"  // 실제 JWT 토큰으로 교체

        // 서버로부터 유저 정보를 요청
        userViewModel.getUserInfo(token)

        // LiveData를 관찰하여 유저 정보가 변경되면 UI 업데이트
        userViewModel.userInfo.observe(viewLifecycleOwner) { userResponse ->
            // userInfo가 null이 아닐 때만 UI를 업데이트
            userResponse?.let {
                // 로그에 유저 정보를 출력
                Log.d("testt", "User Info: ${it.user.nickname}")

                // TextView에 유저 닉네임 표시
                val userNicknameTextView = view.findViewById<TextView>(R.id.userNicknameTextView)
                userNicknameTextView.text = it.user.nickname  // 서버로부터 받은 닉네임을 표시
            }
        }
    }
}

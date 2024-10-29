package com.project.view.main

import android.view.View
import android.widget.TextView
import com.project.R

class MainUserInfo(view: View) {
    private val textViewNickname: TextView = view.findViewById(R.id.textViewNickname)
    private val textViewPostCount: TextView = view.findViewById(R.id.textViewPostCount)

    fun setUserInfo(nickname: String, postCount: Int) {
        textViewNickname.text = "닉네임: $nickname"
        textViewPostCount.text = "포스트 개수: $postCount"
    }

    fun resetUserInfo() {
        textViewNickname.text = "닉네임: 사용자이름"
        textViewPostCount.text = "포스트 개수: 0"
    }
}

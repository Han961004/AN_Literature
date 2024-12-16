package com.project.ui.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import com.project.models.NavBar

class MainViewModel : ViewModel() {

    private val _userDetails = MutableLiveData<NavBar>()
    val userDetails: LiveData<NavBar> get() = _userDetails

    /* 유저 정보 설정
     * 로그인 한 다음, 유저 정보를 MainActivity에서 보관
     */
    fun setUserInfo(nickname: String, jwt: String) {
        _userDetails.value = NavBar(nickname, jwt)
        Log.d("testt", "Nickname set in NavBar: $nickname, JWT set: $jwt")
    }

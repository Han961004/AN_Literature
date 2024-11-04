package com.project.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import android.util.Log
import com.project.model.remote.dataclass.NavBar

class MainViewModel() : ViewModel() {

    private val _userDetails = MutableLiveData<NavBar>()
    val userDetails: LiveData<NavBar> get() = _userDetails

    /* 유저 정보 설정
    * 로그인 한 다음, 유저 정보를 MainActivity 에서 보관
     */
    fun setUserInfo(username: String) {
        _userDetails.value = NavBar(username)
        Log.d("testt", "Username set in NavBar: $username")
    }

}
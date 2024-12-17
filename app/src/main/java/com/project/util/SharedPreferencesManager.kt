package com.project.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {
    private const val PREF_NAME = "AuthPrefs"
    private const val KEY_TOKEN = "jwt_token"
    private const val KEY_AUTO_LOGIN = "auto_login"

    private lateinit var preferences: SharedPreferences

    // 초기화: Application에서 호출
    fun init(context: Context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // 토큰 저장
    fun saveToken(token: String) {
        preferences.edit().putString(KEY_TOKEN, token).apply()
    }

    // 토큰 가져오기
    fun getToken(): String? = preferences.getString(KEY_TOKEN, null)

    // 자동 로그인 여부 확인
    fun isAutoLoginEnabled(): Boolean = preferences.getBoolean(KEY_AUTO_LOGIN, false)

    // 로그인 초기화 (로그아웃)
    fun clearLogin() {
        preferences.edit().clear().apply()
    }
}

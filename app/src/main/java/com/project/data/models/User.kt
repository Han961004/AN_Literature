package com.project.models

import java.util.Date

data class User(
    /*
     * all user's list
     */
    val email: String,
    val lastLogin: Date,
    val dateJoined: Date,
)


data class UserCreateRequest(
    val email: String,
    val password: String
)

data class CommonSignInResponse(
    val jwt: String,
    val user: UserInfo, // 서버에서 받은 user 객체와 일치하도록 UserInfo 클래스 추가
)

data class UserInfo(
    val id: Int,
    val username: String,
    val email: String
)

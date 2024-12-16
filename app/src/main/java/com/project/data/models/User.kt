package com.project.data.models

import java.util.Date

data class User(
    /*
     * all user's list
     * only staff & admin
     */
    val id: Int,
    val email: String,
    val lastLogin: Date,
    val dateJoined: Date?,
    val isSuperuser: Boolean,
    val isStaff: Boolean,
    val isActive: Boolean
)

data class UserDetail(
    /*
     * user's detail
     * all user 열람 가능
     */
    val id: Int,
    val email: String,
    val lastLogin: Date?,
    val dateJoined: Date
)

data class UserCreate(
    /*
     * create user
     * profile 자동 생성
     * nickname -> 자동 생성으로 바꾸기
     */
    val email: String,
    val password: String,
    val nickname: String? = null
)
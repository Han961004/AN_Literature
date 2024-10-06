package com.project.model.remote.dataclass

data class SignUpRequest(
    val id: String,
    val email: String,
    val password: String,
    val nickname: String
)

data class SignInRequest(
    val id: String,
    val password: String
)

data class SignInResponse(
    val token: String
)







data class UserResponse(
    val user: UserInfo
)

data class UserInfo(
    val id: String,
    val nickname: String
)
data class UserDetailResponse(
    val nickname: String,
    val postCount: Int
)

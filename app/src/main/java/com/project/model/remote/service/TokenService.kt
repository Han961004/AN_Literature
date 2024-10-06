package com.project.model.remote.service

import com.project.model.remote.dataclass.RefreshTokenRequest
import com.project.model.remote.dataclass.RefreshTokenResponse
import com.project.model.remote.dataclass.UserResponse
import retrofit2.http.*
import retrofit2.Response

interface TokenService {

    // === 토큰 === //
    @POST("/api/auth/refresh")
    suspend fun refreshToken(
        @Body request: RefreshTokenRequest
    ): Response<RefreshTokenResponse>



    // === 유저 정보 === //
    @GET("/api/user")
    suspend fun getUserInfo(
        @Header("Authorization") token: String  // JWT 토큰을 헤더에 포함
    ): Response<UserResponse>
}
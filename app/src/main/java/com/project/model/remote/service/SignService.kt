package com.project.model.remote.service

import com.project.model.remote.dataclass.SignInRequest
import com.project.model.remote.dataclass.SignInResponse
import com.project.model.remote.dataclass.SignUpRequest
import com.project.model.remote.dataclass.UserDetailResponse
import com.project.model.remote.dataclass.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface SignService {

    @POST("/api/auth/signup")
    fun signUp(
        @Body request: SignUpRequest
    ): Call<Void>

    @POST("/api/auth/signin")
    fun signIn(
        @Body request: SignInRequest
    ): Call<SignInResponse>

    // === 계정 정보 관련 === //
    @GET("/api/user")
    suspend fun getUserInfo(
        @Header("Authorization") token: String
    ): Response<UserResponse>


    @GET("api/users/{user_id}/")
    suspend fun getUserDetails(
        @Path("user_id") userId: Int
    ): Response<UserDetailResponse>


}
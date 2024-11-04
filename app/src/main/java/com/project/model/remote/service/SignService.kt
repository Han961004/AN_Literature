package com.project.model.remote.service

import com.project.model.remote.dataclass.KakaoSignInResponse
import com.project.model.remote.dataclass.LocalSignInRequest
import com.project.model.remote.dataclass.LocalSignInResponse
import com.project.model.remote.dataclass.LocalSignUpRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface SignService {

    /* 개요
    * 로컬 회원 가입 요청
    * 로컬 로그인 요청
    * 카카오 로그인 요청
    *
    * 
    * 개인 설정도 하면 좋겠다 예를 들어 글자 크기 라던가
     */
    
    /* 로컬 회원 가입 요청
    * Call<Void> 로 success Response
     */
    @POST("api/sign/up/")
    suspend fun localSignUpRequest(
        @Body request: LocalSignUpRequest
    ): Response<Void>

    /* 로컬 로그인 요청
    * SignInResponse 로 유저의 정보 Response
     */
    @POST("api/sign/in/local/")
    suspend fun localSignInRequest(
        @Body request: LocalSignInRequest
    ): Response<LocalSignInResponse>
    
    /* 카카오 로그인 요청
    * 헤더에 AccessToken 넣고 보냄
    * 반환은 jwt 와 유저 정보를 받아냄
     */
    @POST("api/sign/in/kakao/")
    @Headers("Content-Type: application/json")
    suspend fun kakaoSignInRequest(
        @Header("Authorization") token: String
    ): Response<KakaoSignInResponse>
    

}
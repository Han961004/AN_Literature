package com.project.data.api

import com.project.models.CommonSignInResponse
import com.project.models.remote.dataclass.CommonSignUpRequest
import com.project.models.remote.dataclass.KakaoSignInRequest
import com.project.models.remote.dataclass.LocalSignInRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignService {

    /* 개요
    * 회원 가입
    * 로그인
    * 로그아웃
    *
    * 카카오 로그인
    * 
    * 개인 설정도 하면 좋겠다 예를 들어 글자 크기 라던가
     */
    
    /* 공통 회원 가입
    * Call<Void> 로 success Response
     */
    @POST("api/auth/sign-up/common/")
    suspend fun commonSignUp(
        @Body commonSignUpRequest: CommonSignUpRequest
    ): Response<ResponseBody>

    /* 로컬 로그인
    * SignInResponse 로 유저의 정보 Response
     */
    @POST("api/auth/sign-in/local/")
    suspend fun localSignIn(
        @Body localSignInRequest: LocalSignInRequest
    ): Response<CommonSignInResponse>

    /* 카카오 로그인
    * 반환은 jwt 와 유저 정보를 받아냄
     */
    @POST("api/auth/sign-in/kakao/")
    @Headers("Content-Type: application/json")
    suspend fun kakaoSignIn(
        @Body kakaoSignInRequest: KakaoSignInRequest
    ): Response<CommonSignInResponse>

    /* 로그아웃
    *
     */
    @POST("api/auth/sign-out/common/")
    suspend fun commonSignOut(

    ) : Response<Void>
}
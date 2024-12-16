package com.project.data.api

import com.project.data.models.Login
import com.project.data.models.Token
import com.project.data.models.UserCreate
import retrofit2.Response
import retrofit2.http.*

interface AccountsService {

    @POST("v1/accounts/login/")
    suspend fun loginRequest(
        @Body request: Login
    ): Response<Token>

    @POST("v1/accounts/logout/")
    suspend fun logoutRequest(): Response<Void>

    @POST("v1/accounts/create/")
    suspend fun userCreateRequest(
        @Body request: UserCreate
    ): Response<Void>

}
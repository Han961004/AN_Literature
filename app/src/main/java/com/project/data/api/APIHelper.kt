package com.project.data.api

import com.project.data.models.Login
import com.project.data.models.UserCreate

class ApiHelper(private val accountsService: AccountsService) {

    suspend fun login(request: Login) = accountsService.loginRequest(request)

    suspend fun logout() = accountsService.logoutRequest()

    suspend fun userCreate(request: UserCreate) = accountsService.userCreateRequest(request)
}

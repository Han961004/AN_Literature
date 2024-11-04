package com.project.model.remote.service

import com.project.model.remote.dataclass.NavBar
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    /* 개요
    * 드로우 바 반환
     */
    @GET("api/main/")
    suspend fun getMainNav(): Response<NavBar>
}
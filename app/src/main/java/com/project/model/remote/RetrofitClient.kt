package com.project.model.remote

import com.project.model.remote.service.PostService
import com.project.model.remote.service.SignService
import com.project.model.remote.service.TokenService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://3.37.234.231:8080/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val tokenService: TokenService by lazy { retrofit.create(TokenService::class.java) }
    val signService: SignService by lazy { retrofit.create(SignService::class.java) }
    val postsService: PostService by lazy { retrofit.create(PostService::class.java) }

}
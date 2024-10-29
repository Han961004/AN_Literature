package com.project.util

import com.project.model.remote.service.FeedbackService
import com.project.model.remote.service.LoadingService
import com.project.model.remote.service.PostService
import com.project.model.remote.service.SignService
import com.project.model.remote.service.TokenService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://192.168.160.203:8000/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val tokenService: TokenService by lazy { retrofit.create(TokenService::class.java) }
    val signService: SignService by lazy { retrofit.create(SignService::class.java) }
    val postService: PostService by lazy { retrofit.create(PostService::class.java) }
    val feedbackService: FeedbackService by lazy { retrofit.create(FeedbackService::class.java) }
    val loadingService: LoadingService by lazy { retrofit.create(LoadingService::class.java) }
}
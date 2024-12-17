package com.project.util

import com.project.data.api.AccountsService
import com.project.data.api.PostsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderManager {

    private const val BASE_URL = "http://10.113.0.98:8000/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiHelper: ApiHelper by lazy {
        ApiHelper(
            accountsService,
            postsService,
        )
    }

    private val accountsService: AccountsService by lazy { retrofit.create(AccountsService::class.java) }
    private val postsService:PostsService by lazy { retrofit.create(PostsService::class.java) }



}

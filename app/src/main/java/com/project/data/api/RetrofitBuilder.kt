package com.project.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "http://10.113.0.161:8000/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val accountsService: AccountsService by lazy {
        retrofit.create(AccountsService::class.java)
    }

    val apiHelper: ApiHelper by lazy {
        ApiHelper(accountsService)
    }
}

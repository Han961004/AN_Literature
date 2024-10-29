package com.project.model.remote.service

import com.project.model.remote.dataclass.LoadingPost
import retrofit2.Response
import retrofit2.http.GET

interface LoadingService {
    @GET("api/loading/")
    suspend fun getWeeklyTopPosts(): Response<List<LoadingPost>>
}

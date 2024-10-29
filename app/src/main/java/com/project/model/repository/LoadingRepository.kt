//package com.project.model.repository
//
//import com.project.util.RetrofitClient
//import com.project.model.remote.dataclass.LoadingPost
//import retrofit2.Response
//
//class LoadingRepository {
//
//    private val loadingService = RetrofitClient.loadingService
//
//    suspend fun fetchWeeklyTopPosts(): Response<List<LoadingPost>> {
//        return loadingService.getWeeklyTopPosts()
//    }
//}

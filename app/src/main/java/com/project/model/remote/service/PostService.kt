package com.project.model.remote.service

import com.project.model.remote.dataclass.Post
import com.project.model.remote.dataclass.PostDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("postList")
    suspend fun getPostList(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Response<List<Post>>

    @GET("postDetail")
    suspend fun getPostDetail(
        @Path("id") postId: Int
    ): Response<PostDetailResponse>

//    @POST("/post/write")
//    suspend fun

}
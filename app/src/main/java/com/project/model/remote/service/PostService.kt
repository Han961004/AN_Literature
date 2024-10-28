package com.project.model.remote.service

import com.project.model.remote.dataclass.Comment
import com.project.model.remote.dataclass.Post
import com.project.model.remote.dataclass.PostDetailResponse
import com.project.model.remote.dataclass.PostsLoading
import com.project.model.remote.dataclass.PostsRequest
import com.project.model.remote.dataclass.PostsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
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



}
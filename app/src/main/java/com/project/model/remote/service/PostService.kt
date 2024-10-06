package com.project.model.remote.service

import com.project.model.remote.dataclass.Comment
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

    // === 로딩 Posts === //
    @GET("/api/loading")
    suspend fun loadingPosts(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int = 10
    ): List<PostsLoading>

    // === 게시글 Posts 관련 === //
    @POST("/api/posts")
    suspend fun createPost(
        @Header("Authorization") token: String,
        @Body request: PostsRequest
    ): Response<PostsResponse>

    @GET("/api/posts/{post_id}")
    suspend fun getPost(
        @Path("post_id") postId: Int
    ): Response<PostDetailResponse>

    @DELETE("/api/posts/{post_id}")
    suspend fun deletePost(
        @Path("post_id") postId: String
    ): Response<Unit>

    // === 게시글 Comments 관련 === //
    @GET("/api/posts/{postId}/comments")
    fun getComments(
        @Path("postId") postId: String
    ): Call<List<Comment>>

}
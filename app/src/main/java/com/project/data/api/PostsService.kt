package com.project.data.api

import com.project.data.models.Post
import com.project.data.models.PostCreate
import com.project.data.models.PostDetail
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostsService {

    @GET("v1/posts/")
    suspend fun postsList(): Response<List<Post>>

    @GET("v1/posts/{id}/")
    suspend fun postDetailRequest(
        @Path("id") postId: Int
    ): Response<PostDetail>

    @POST("v1/posts/create/")
    suspend fun postCreateRequest(
        @Body request: PostCreate
    ): Response<Void>

}
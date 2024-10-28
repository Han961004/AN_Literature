package com.project.model.remote.dataclass

import java.io.Serializable


/* Post 관련 Data Class
* Post 단일 게시글 정보
* PostList 게시글들을 리스트로 가져올 dataclass
*  */

data class Post(
    val id: Int,
    val title: String,
    val author: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String,
    val likes: Int,
    val comments: List<Comment>
)

data class PostList(
    val id: Int,
    val title: String,
    val author: String
)



data class PostDetailResponse(
    val id: Int,
    val title: String,
    val author_name: String,
    val content: String,
    val likes: Int,
    val created_at: String,
    val updated_at: String
) : Serializable  // Serializable 추가












data class PostsRequest(
    val title: String,
    val content: String
)


data class PostsResponse(
    val title: String,
    val content: String,
    val writingResources: String,
    val author: String,
    val likes: Int
)

data class PostsLoading(
    val title: String,
    val content: String,
    val likes: Int
)

data class Author(
    val id: String,
    val name: String,
    val profilePictureUrl: String // 프로필 사진 URL 추가
)



data class Comment(
    val id: String,
    val author: Author,
    val content: String,
    val createdAt: String
)

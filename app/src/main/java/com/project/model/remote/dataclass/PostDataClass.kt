package com.project.model.remote.dataclass


data class PostsRequest(
    val title: String,
    val content: String
)

data class PostDetailResponse(
    val id: Int,
    val title: String,
    val content: String,
    val author_name: String,
    val likes: Int,
    val created_at: String,
    val updated_at: String
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

data class Posts(
    val id: String,
    val title: String,
    val content: String,
    val writingResources: String,
    val author: Author,
    val createdAt: String,
    val updatedAt: String,
    val likes: Int, // 좋아요 수 추가
    val comments: List<Comment> // 댓글 목록 추가
)

data class Comment(
    val id: String,
    val author: Author,
    val content: String,
    val createdAt: String
)

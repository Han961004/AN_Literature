package com.project.data.models

import java.util.Date

data class Post(
    /*
     * post's list
     */
    val id: Int,
    val title: String,
    val user: String,
)

data class PostDetail(
    val id: Int,
    val user: String,
    val title: String,
    val content: String,
    val like: Int,
    val createdAt: Date,
    val updatedAt: Date,
)

data class PostCreate(
    val title: String,
    val content: String,
)
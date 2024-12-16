package com.project.data.models

data class ProfileDetail(
    /*
     * all user's profile list
     */
    val id: Int,
    val email: String,
    val nickname: String?,
    val bio: String?,
    val platform: String?
)

data class ProfileUpdate(
    val nickname: String?,
    val bio: String?,
    val platform: String?
)
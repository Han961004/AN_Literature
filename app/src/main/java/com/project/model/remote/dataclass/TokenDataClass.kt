package com.project.model.remote.dataclass

data class RefreshTokenRequest(
    val refreshToken: String
)

data class RefreshTokenResponse(
    val newAccessToken: String,
    val newRefreshToken: String
)

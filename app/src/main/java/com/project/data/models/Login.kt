package com.project.data.models

data class Login(
    val email: String,
    val password: String
)

data class Token(
    val token: String
)
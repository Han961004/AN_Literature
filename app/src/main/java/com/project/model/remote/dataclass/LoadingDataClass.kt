package com.project.model.remote.dataclass

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoadingPost(
    val id: Int,
    val author: Int,  // ID가 아닌 실제 작성자의 이름이 필요하다면 String으로 바꾸고 API 수정 필요
    val title: String,
    @SerializedName("post_content") val content: String, // 서버 필드 이름과 맞춤
    val likes: Int
) : Parcelable

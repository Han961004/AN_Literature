package com.project.model.remote.dataclass

/* 개요
* 드로우 바 (네비 바) 정보
*
 */

/* 드로우 바
* 드로우 바 안에 들어갈 정보
* 유저 닉네임, 총 게시글 수, 총 좋아요 수 등등
 */
data class NavBar(
    val name: String
)
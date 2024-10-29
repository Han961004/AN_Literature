package com.project.model.remote.dataclass


/* 첨삭 관련 Data Class
* FeedbackList 첨삭 요청 글들을 리스트로 가져옴

 */

data class Feedback(
    val id : Int,
)

data class FeedbackList (
    val id : Int,
    val title: String,
    val author: String
)
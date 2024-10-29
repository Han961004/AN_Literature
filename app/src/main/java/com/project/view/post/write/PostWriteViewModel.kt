package com.project.view.post.write

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostWriteViewModel : ViewModel() {

    // 작성 중인 글 내용 관리
    private val _content = MutableLiveData<String>()
    val content: LiveData<String> get() = _content

    // 내용 설정 함수
    fun setContent(text: String) {
        _content.value = text
    }

    // 게시글 저장 로직 (Room에 저장하거나 서버로 전송하는 기능 추가 가능)
    fun savePost() {
        // 실제 저장 또는 업로드 로직 구현
    }
}

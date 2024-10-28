package com.project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.model.remote.dataclass.PostDetailResponse

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<PostDetailResponse>>() // 게시글 리스트 라이브 데이터
    val posts: LiveData<List<PostDetailResponse>> get() = _posts

    fun getPosts() {  // 메서드 이름을 getPosts로 변경
        // 가상의 게시글 목록
        val fakePosts = listOf(
            PostDetailResponse(
                id = 1,
                title = "Sample Post 1",
                author_name = "Author 1",
                content = "This is the content of Sample Post 1.",
                likes = 100,
                created_at = "2023-10-01",
                updated_at = "2023-10-02"
            ),
            PostDetailResponse(
                id = 2,
                title = "Sample Post 2",
                author_name = "Author 2",
                content = "This is the content of Sample Post 2.",
                likes = 150,
                created_at = "2023-10-05",
                updated_at = "2023-10-06"
            )
        )
        _posts.value = fakePosts // 라이브 데이터에 게시글 리스트 설정
    }
}



//        viewModelScope.launch {
//            try {
//                val response = RetrofitClient.postService.getPostDetail(postId)
//                if (response.isSuccessful) {
//                    _post.value = response.body()
//                } else {
//                    _post.value = null
//                }
//            } catch (e: HttpException) {
//                _post.value = null
//            } catch (e: IOException) {
//                _post.value = null
//            }
//        }
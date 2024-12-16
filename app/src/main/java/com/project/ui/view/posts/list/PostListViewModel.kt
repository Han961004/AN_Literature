//package com.project.view.post.list
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.project.model.remote.service.PostService
//import kotlinx.coroutines.launch
//import retrofit2.Response
//import android.util.Log
//import com.project.model.remote.dataclass.PaginatedResponse
//import com.project.model.remote.dataclass.PostsResponse
//import com.project.util.RetrofitClient
//
//class PostListViewModel : ViewModel() {
//
//    private val postService = RetrofitClient.postService  // 직접 초기화
//
//    private val _postList = MutableLiveData<List<PostsResponse>>() // List<Post>로 수정
//    val postList: LiveData<List<PostsResponse>> get() = _postList
//
//    private val _isLoading = MutableLiveData<Boolean>()
//    val isLoading: LiveData<Boolean> get() = _isLoading
//
//    fun loadPosts(page: Int, size: Int) {
//        _isLoading.value = true
//        viewModelScope.launch {
//            try {
//                val response: Response<PaginatedResponse<PostsResponse>> = postService.getPostList(page, size)
//                if (response.isSuccessful) {
//                    val posts = response.body()?.results ?: emptyList()
//                    _postList.value = posts
//                    Log.d("testt", "Received Post Data: $posts")
//                } else {
//                    Log.e("testt", "Error: ${response.code()}")
//                }
//            } catch (e: Exception) {
//                Log.e("testt", "Exception: ${e.message}")
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//
//}

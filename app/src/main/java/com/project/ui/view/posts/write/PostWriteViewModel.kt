//package com.project.view.post.write
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.project.util.RetrofitClient
//import kotlinx.coroutines.launch
//import retrofit2.HttpException
//import android.util.Log
//import com.project.model.remote.dataclass.CreatePostRequest
//
//class PostWriteViewModel : ViewModel() {
//
//    private val postService = RetrofitClient.postService
//
//    private val _content = MutableLiveData<String>()
//    val content: LiveData<String> get() = _content
//
//    private val _title = MutableLiveData<String>()
//    val title: LiveData<String> get() = _title
//
//    private val _saveSuccess = MutableLiveData<Boolean>()
//    val saveSuccess: LiveData<Boolean> get() = _saveSuccess
//
//    private val _errorMessage = MutableLiveData<String>()
//    val errorMessage: LiveData<String> get() = _errorMessage
//
//    fun setContent(text: String) {
//        _content.value = text
//    }
//
//    fun setTitle(title: String) {
//        _title.value = title
//    }
//
//    // ViewModel 수정
//    fun savePost() {
//        // PostRequest 객체 생성
//        val postRequest = CreatePostRequest(
//            title = _title.value ?: "",
//            post_content = _content.value ?: "",
//            authorId = 1  // 기본값으로 설정하거나 로그인된 사용자 ID로 변경
//        )
//
//        viewModelScope.launch {
//            try {
//                val response = postService.createPostRequest(postRequest)  // postRequest 전달
//                if (response.isSuccessful) {
//                    _saveSuccess.value = true
//                } else {
//                    _errorMessage.value = "Failed to save post: ${response.message()}"
//                }
//            } catch (e: HttpException) {
//                _errorMessage.value = "Network error: ${e.message}"
//            } catch (e: Exception) {
//                _errorMessage.value = "Unexpected error: ${e.message}"
//            }
//        }
//    }
//}

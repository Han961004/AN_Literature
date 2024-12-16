//package com.project.view.post.detail
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.project.model.remote.service.PostService  // Retrofit 서비스
//import com.project.model.remote.dataclass.GetPostDetailResponse
//import com.project.data.api.RetrofitBuilder
//import kotlinx.coroutines.launch
//import retrofit2.Response
//import android.util.Log
//
//class PostDetailViewModel : ViewModel() {
//
//    private val postService = RetrofitBuilder.postService  // Retrofit 서비스 인스턴스
//
//    private val _postDetail = MutableLiveData<GetPostDetailResponse>()  // 단일 포스트 라이브 데이터
//    val postDetail: LiveData<GetPostDetailResponse> get() = _postDetail
//
//    // 특정 포스트 ID로 포스트 상세 정보를 로드하는 메서드
//    fun loadPostDetails(postId: Int) {
//        viewModelScope.launch {
//            try {
//                val response: Response<GetPostDetailResponse> = postService.getPostDetail(postId)  // 포스트 세부 정보 요청
//                if (response.isSuccessful) {
//                    _postDetail.value = response.body()  // 데이터 업데이트
//                } else {
//                    Log.e("testt", "Error fetching post details: ${response.code()}")
//                }
//            } catch (e: Exception) {
//                Log.e("testt", "Exception: ${e.message}")
//            }
//        }
//    }
//}

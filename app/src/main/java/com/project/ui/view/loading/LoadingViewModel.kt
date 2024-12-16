//package com.project.view.loading
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.project.model.remote.dataclass.GetLoadingPost
//import com.project.util.RetrofitClient
//import kotlinx.coroutines.launch
//
//class LoadingViewModel : ViewModel() {
//
//    private val _posts = MutableLiveData<List<GetLoadingPost>>()
//    val posts: LiveData<List<GetLoadingPost>> get() = _posts
//
//    private val _error = MutableLiveData<String>()
//    val error: LiveData<String> get() = _error
//
//    private val loadingService = RetrofitClient.postService
//
//    fun loadTop5Posts() {
//        viewModelScope.launch {
//            try {
//                val response = loadingService.getWeeklyPosts()
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        _posts.value = it
//                        Log.d("testt", "Posts loaded: $it")
//                    } ?: run {
//                        _error.value = "No data received from server."
//                        Log.e("testt", "Response body is null")
//                    }
//                } else {
//                    val errorMsg = "Error: ${response.code()} ${response.message()}"
//                    _error.value = errorMsg
//                    Log.e("testt", errorMsg)
//                }
//            } catch (e: Exception) {
//                val errorMsg = "Unexpected error: ${e.localizedMessage}"
//                _error.value = errorMsg
//                Log.e("testt", errorMsg)
//            }
//        }
//    }
//}

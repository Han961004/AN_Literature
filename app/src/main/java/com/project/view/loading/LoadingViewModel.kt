package com.project.view.loading

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.util.RetrofitClient
import com.project.model.remote.dataclass.LoadingPost
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<LoadingPost>>()
    val posts: LiveData<List<LoadingPost>> get() = _posts

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val loadingService = RetrofitClient.loadingService

    fun loadTop5Posts() {
        viewModelScope.launch {
            try {
                val response = loadingService.getWeeklyTopPosts()
                if (response.isSuccessful) {
                    _posts.value = response.body()
                    Log.d("LoadingViewModel", "Posts loaded: ${response.body()}")
                } else {
                    _error.value = "Error: ${response.code()} ${response.message()}"
                    Log.e("LoadingViewModel", "Error response: ${response.code()} ${response.message()}")
                }
            } catch (e: Exception) {
                _error.value = "Exception: ${e.localizedMessage}"
                Log.e("LoadingViewModel", "Exception: ${e.localizedMessage}")
            }
        }
    }

}

// PostViewModel.kt
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.model.remote.RetrofitClient
import com.project.model.remote.dataclass.PostDetailResponse
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _post = MutableLiveData<PostDetailResponse>()
    val post: LiveData<PostDetailResponse> get() = _post

    fun getPostDetail(postId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.postsService.getPost(postId)
                if (response.isSuccessful) {
                    _post.value = response.body()
                } else {
                    Log.e("Error", "Failed to fetch post: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("Error", "Exception occurred: ${e.message}")
            }
        }
    }
}

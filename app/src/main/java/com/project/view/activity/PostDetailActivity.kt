package com.project.view.activity

// PostDetailActivity.kt
import PostViewModel
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.R
import com.project.databinding.ActivityPostDetailBinding
import com.project.model.remote.dataclass.PostDetailResponse

class PostDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostDetailBinding
    private var postId: Int = 0
    private lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        postId = intent.getIntExtra("post_id", 1)

        viewModel.getPostDetail(postId)

        viewModel.post.observe(this, { post ->
            post?.let { setupUI(it) } ?: run {
                Toast.makeText(this, "Failed to load post", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupUI(post: PostDetailResponse) {
        binding.textViewTitle.text = post.title
        binding.textViewAuthor.text = post.author_name
        binding.textViewContent.text = post.content
        binding.textViewLikes.text = "${post.likes} likes"
    }
}

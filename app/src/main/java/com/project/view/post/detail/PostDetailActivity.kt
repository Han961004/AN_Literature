package com.project.view.post.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.R
import com.project.databinding.ActivityPostDetailBinding
import com.project.model.remote.dataclass.PostDetailResponse
import com.project.view.post.PostPagerAdapter

class PostDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostDetailBinding
    private lateinit var viewModel: PostDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
        viewModel = ViewModelProvider(this).get(PostDetailViewModel::class.java)

        val postId = intent.getIntExtra("post_id", -1)
        if (postId != -1) {
            viewModel.getPosts()  // 모든 게시글을 가져오는 메서드 호출
        } else {
            Toast.makeText(this, "Post ID not found", Toast.LENGTH_SHORT).show()
            finish()
        }

        viewModel.posts.observe(this) { posts -> // posts로 변경
            if (!posts.isNullOrEmpty()) { // 리스트가 비어있지 않은지 확인
                setupViewPager(posts)
                val startPosition = posts.indexOfFirst { it.id == postId }
                if (startPosition != -1) {
                    binding.viewPager.setCurrentItem(startPosition, false)
                }
            } else {
                Toast.makeText(this, "Failed to load posts", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupViewPager(posts: List<PostDetailResponse>) {
        val adapter = PostPagerAdapter(this, posts)
        binding.viewPager.adapter = adapter
    }
}

//package com.project.view.post.detail
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProvider
//import com.project.R
//import com.project.databinding.ActivityPostDetailBinding
//import com.project.model.remote.dataclass.GetPostDetailResponse
//import com.project.view.post.PostPagerAdapter
//
//class PostDetailActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPostDetailBinding
//    private lateinit var viewModel: PostDetailViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
//        viewModel = ViewModelProvider(this).get(PostDetailViewModel::class.java)
//
//        val postId = intent.getIntExtra("post_id", -1)  // 키 이름을 "POST_ID"로 변경
//        if (postId != -1) {
//            viewModel.loadPostDetails(postId)  // 특정 포스트 세부 정보 로드
//        } else {
//            Toast.makeText(this, "Post ID not found", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//
//        viewModel.postDetail.observe(this) { postDetail ->
//            postDetail?.let { setupViewPager(listOf(it)) }  // 단일 포스트 정보를 ViewPager에 설정
//        }
//    }
//
//    private fun setupViewPager(posts: List<GetPostDetailResponse>) {
//        val adapter = PostPagerAdapter(this, posts)
//        binding.viewPager.adapter = adapter
//    }
//}

package com.project.view.activity

import PostViewModel
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.project.databinding.ActivityLoadingBinding
import com.project.model.remote.dataclass.PostsLoading
import com.project.util.PostPagerAdapter
class LoadingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadingBinding

    private val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGoToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        setupObservers()
//        viewModel.loadTop10Posts()
    }

    private fun setupObservers() {
//        viewModel.posts.observe(this, Observer { posts ->
//            setupViewPager(posts)
//        })
    }

    private fun setupViewPager(posts: List<PostsLoading>) {
        val adapter = PostPagerAdapter(posts)
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.setViewPager2(binding.viewPager) // DotsIndicator와 ViewPager2 연결
    }

}

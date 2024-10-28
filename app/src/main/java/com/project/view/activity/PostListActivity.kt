package com.project.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.databinding.ActivityPostListBinding
import com.project.model.remote.dataclass.PostList
import com.project.util.PostAdapter

class PostListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostListBinding
    private var isLoading = false
    private var currentPage = 1
    private val pageSize = 20
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSwipeRefresh()
        loadPosts(currentPage)
    }

    private fun setupRecyclerView() {
        adapter = PostAdapter(this, mutableListOf()) // 빈 리스트로 초기화
        binding.recyclerViewPosts.adapter = adapter
        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(this)
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            currentPage = 1 // 페이지 초기화
            loadPosts(currentPage) // 서버에서 데이터 다시 불러오기
        }
    }

    private fun loadPosts(page: Int) {
        // 새로고침 시 기존 데이터 초기화
        if (page == 1) {
            adapter.setPosts(emptyList())  // 데이터 초기화
        }

        // 예시 데이터로 리스트 추가
        val samplePosts = listOf(
            PostList(id = 1, title = "Sample Post 1", author = "Author 1"),
            PostList(id = 2, title = "Sample Post 2", author = "Author 2")
        )

        if (page == 1) {
            adapter.setPosts(samplePosts) // 첫 페이지면 기존 데이터 초기화
        } else {
            adapter.addPosts(samplePosts) // 추가 페이지면 데이터 추가
        }

        isLoading = false
        binding.swipeRefreshLayout.isRefreshing = false // 새로고침 완료 상태 해제
    }
}

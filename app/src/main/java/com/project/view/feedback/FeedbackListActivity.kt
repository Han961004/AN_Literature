package com.project.view.feedback

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.databinding.ActivityFeedbackListBinding
import com.project.model.remote.dataclass.FeedbackList

class FeedbackListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedbackListBinding
    private var isLoading = false
    private var currentPage = 1
    private val pageSize = 20
    private lateinit var adapter: FeedbackAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSwipeRefresh()
        loadFeedbacks(currentPage)
    }

    private fun setupRecyclerView() {
        adapter = FeedbackAdapter(this, mutableListOf()) // 빈 리스트로 초기화
        binding.recyclerViewFeedback.adapter = adapter
        binding.recyclerViewFeedback.layoutManager = LinearLayoutManager(this)
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            currentPage = 1 // 페이지 초기화
            loadFeedbacks(currentPage) // 서버에서 데이터 다시 불러오기
        }
    }

    private fun loadFeedbacks(page: Int) {
        // 새로고침 시 기존 데이터 초기화
        if (page == 1) {
            adapter.setFeedbacks(emptyList())  // 데이터 초기화
        }

        // 예시 데이터로 리스트 추가
        val sampleFeedbacks = listOf(
            FeedbackList(id = 1, title = "Sample Feedback 1", author = "Author 1"),
            FeedbackList(id = 2, title = "Sample Feedback 2", author = "Author 2")
        )

        if (page == 1) {
            adapter.setFeedbacks(sampleFeedbacks) // 첫 페이지면 기존 데이터 초기화
        } else {
            adapter.addFeedbacks(sampleFeedbacks) // 추가 페이지면 데이터 추가
        }

        isLoading = false
        binding.swipeRefreshLayout.isRefreshing = false // 새로고침 완료 상태 해제
    }
}

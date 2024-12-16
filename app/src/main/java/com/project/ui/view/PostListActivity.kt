//package com.project.view.post.list
//
//import PostAdapter
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.ViewModel
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.project.databinding.ActivityPostListBinding
//import com.project.view.post.write.PostWriteActivity  // 추가: WritePostActivity를 가져옴
//
//class PostListActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPostListBinding
//    private val viewModel: PostListViewModel by viewModels()  // 기본 ViewModel 초기화
//    private lateinit var adapter: PostAdapter
//    private var currentPage = 1
//    private val pageSize = 20
//    private var isLoading = false // isLoading 변수 추가
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityPostListBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        setupRecyclerView()
//        setupSwipeRefresh()
//        observeViewModel()
//        setupWritePostButton()  // 글쓰기 버튼 설정
//
//        viewModel.loadPosts(currentPage, pageSize)
//    }
//
//    private fun setupRecyclerView() {
//        adapter = PostAdapter(this, mutableListOf())
//        binding.recyclerViewPosts.adapter = adapter
//        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(this)
//    }
//
//    private fun setupSwipeRefresh() {
//        binding.swipeRefreshLayout.setOnRefreshListener {
//            currentPage = 1
//            viewModel.loadPosts(currentPage, pageSize)
//        }
//    }
//
//    private fun observeViewModel() {
//        viewModel.postList.observe(this) { posts ->
//            if (currentPage == 1) {
//                adapter.setPosts(posts)
//            } else {
//                adapter.addPosts(posts)
//            }
//            binding.swipeRefreshLayout.isRefreshing = false
//        }
//
//        viewModel.isLoading.observe(this) { isLoading ->
//            this.isLoading = isLoading
//        }
//    }
//
//    private fun setupWritePostButton() {
//        binding.buttonWritePost.setOnClickListener {
//            // WritePostActivity로 이동
//            val intent = Intent(this, PostWriteActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}

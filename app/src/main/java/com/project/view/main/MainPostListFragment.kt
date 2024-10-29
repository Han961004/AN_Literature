package com.project.view.main//package com.project.view.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.lifecycleScope
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.project.databinding.FragmentPostListBinding
//import com.project.util.RetrofitClient
//import kotlinx.coroutines.launch
//import retrofit2.HttpException
//import java.io.IOException
//
//class MainPostListFragment : Fragment() {
//
//    private var _binding: FragmentPostListBinding? = null
//    private val binding get() = _binding!!
//    private var isLoading = false
//    private var currentPage = 1
//    private val pageSize = 20
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentPostListBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
////        setupRecyclerView()
////        loadPosts(currentPage)
//    }
//
////    private fun setupRecyclerView() {
////        adapter = PostsAdapter()
////        binding.recyclerViewPosts.adapter = adapter
////        binding.recyclerViewPosts.layoutManager = LinearLayoutManager(context)
////
////        binding.recyclerViewPosts.addOnScrollListener(object : RecyclerView.OnScrollListener() {
////            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
////                super.onScrolled(recyclerView, dx, dy)
////                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
////                val visibleItemCount = layoutManager.childCount
////                val totalItemCount = layoutManager.itemCount
////                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
////
////                if (!isLoading && (visibleItemCount + firstVisibleItemPosition >= totalItemCount) && firstVisibleItemPosition >= 0 && totalItemCount >= pageSize) {
////                    currentPage++
////                    loadPosts(currentPage)
////                }
////            }
////        })
////    }
////
////    private fun loadPosts(page: Int) {
////        isLoading = true
////        lifecycleScope.launch {
////            try {
////                val response = RetrofitClient.postService.getPosts(page, pageSize)
////                if (response.isSuccessful) {
////                    val posts = response.body() ?: emptyList()
////                    adapter.addPosts(posts)
////                } else {
////                    Toast.makeText(context, "Failed to load posts", Toast.LENGTH_SHORT).show()
////                }
////            } catch (e: HttpException) {
////                Toast.makeText(context, "HTTP Error", Toast.LENGTH_SHORT).show()
////            } catch (e: IOException) {
////                Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show()
////            } finally {
////                isLoading = false
////            }
////        }
////    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

package com.project.ui.view//package com.project.view.loading
//
//import android.content.Intent
//import android.os.Bundle
//import android.util.Log
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.viewpager2.adapter.FragmentStateAdapter
//import com.project.databinding.ActivityPostLoadingBinding
//import com.project.model.remote.dataclass.
//import com.project.view.main.MainActivity
//import dagger.hilt.android.AndroidEntryPoint
//
//class LoadingActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPostLoadingBinding
//    private val viewModel: LoadingViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityPostLoadingBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.btnGoToMain.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//        setupObservers()
//        viewModel.loadTop5Posts()
//    }
//
//    private fun setupObservers() {
//        viewModel.posts.observe(this) { posts ->
//            if (posts.isNullOrEmpty()) {
//                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
//            } else {
//                setupViewPager(posts)
//            }
//        }
//    }
//
//    private fun setupViewPager(posts: List<GetLoadingPost>) {
//        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
//            override fun getItemCount(): Int = posts.size
//
//            override fun createFragment(position: Int): Fragment {
//                return LoadingFragment.newInstance(posts[position])
//            }
//        }
//        binding.dotsIndicator.setViewPager2(binding.viewPager)
//    }
//}

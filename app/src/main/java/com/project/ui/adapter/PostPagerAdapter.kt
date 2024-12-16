//package com.project.ui.adapter//package com.project.view.post
////
////import androidx.fragment.app.Fragment
////import androidx.fragment.app.FragmentActivity
////import androidx.viewpager2.adapter.FragmentStateAdapter
////import com.project.model.remote.dataclass.GetPostDetailResponse
////import com.project.view.post.detail.PostDetailFragment
////
////class PostPagerAdapter(
////    fragmentActivity: FragmentActivity,
////    private val posts: List<GetPostDetailResponse>
////) : FragmentStateAdapter(fragmentActivity) {
////
////    override fun getItemCount(): Int = posts.size
////
////    override fun createFragment(position: Int): Fragment {
////        return PostDetailFragment.newInstance(posts[position])
////    }
////}

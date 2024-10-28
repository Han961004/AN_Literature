package com.project.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.model.remote.dataclass.PostDetailResponse
import com.project.view.fragment.PostDetailFragment

class PostPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val posts: List<PostDetailResponse>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = posts.size

    override fun createFragment(position: Int): Fragment {
        return PostDetailFragment.newInstance(posts[position])
    }
}

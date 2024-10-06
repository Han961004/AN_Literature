package com.project.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.databinding.ItemPostBinding
import com.project.model.remote.dataclass.PostsLoading

class PostPagerAdapter(private val posts: List<PostsLoading>) : RecyclerView.Adapter<PostPagerAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    inner class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostsLoading) {
            binding.tvTitle.text = post.title
            binding.tvContent.text = post.content
            binding.tvLikes.text = "Likes: ${post.likes}"
        }
    }
}

package com.project.view.post

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.databinding.ActivityPostListItemBinding
import com.project.model.remote.dataclass.PostList
import com.project.view.post.detail.PostDetailActivity

class PostAdapter(
    private val context: Context,
    private val posts: MutableList<PostList>
) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(private val binding: ActivityPostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostList) {
            binding.textViewTitle.text = post.title
            binding.textViewAuthor.text = post.author

            // 아이템 클릭 리스너 설정
            binding.root.setOnClickListener {
                val intent = Intent(context, PostDetailActivity::class.java)
                intent.putExtra("post_id", post.id)
                context.startActivity(intent)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ActivityPostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    fun addPosts(newPosts: List<PostList>) {
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

    fun setPosts(newPosts: List<PostList>) {
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

}

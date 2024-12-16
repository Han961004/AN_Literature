package com.project.ui.adapter//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.project.databinding.ActivityPostListItemBinding
//import com.project.model.remote.dataclass.PostsResponse
//import com.project.view.post.detail.PostDetailActivity
//
//class PostAdapter(
//    private val context: Context,
//    private val postList: MutableList<PostsResponse>
//) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
//
//    fun setPosts(posts: List<PostsResponse>) {
//        postList.clear()
//        postList.addAll(posts)
//        notifyDataSetChanged()
//    }
//
//    fun addPosts(posts: List<PostsResponse>) {
//        postList.addAll(posts)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
//        val binding = ActivityPostListItemBinding.inflate(LayoutInflater.from(context), parent, false)
//        return PostViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
//        holder.bind(postList[position])
//    }
//
//    override fun getItemCount(): Int = postList.size
//
//    inner class PostViewHolder(private val binding: ActivityPostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(post: PostsResponse) {
//            binding.textViewTitle.text = post.title
//            binding.textViewAuthor.text = post.author
//
//            // 아이템 클릭 리스너 추가
//            itemView.setOnClickListener {
//                val intent = Intent(context, PostDetailActivity::class.java).apply {
//                    putExtra("post_id", post.id)  // 선택한 포스트의 ID를 Intent에 추가
//                }
//                context.startActivity(intent)  // PostDetailActivity로 이동
//            }
//        }
//    }
//}

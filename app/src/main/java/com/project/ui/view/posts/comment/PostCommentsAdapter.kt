//package com.project.view.post.comment
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.project.databinding.ActivityPostCommentItemBinding
//import com.project.model.remote.dataclass.Comment
//
//class CommentsAdapter(private val comments: List<Comment>) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {
//
//    class CommentViewHolder(val binding: ActivityPostCommentItemBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
//        val binding = ActivityPostCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CommentViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
//        val comment = comments[position]
//        holder.binding.comment = comment // Data Binding 사용
//        holder.binding.executePendingBindings() // 즉시 UI 업데이트
//    }
//
//    override fun getItemCount(): Int = comments.size
//}

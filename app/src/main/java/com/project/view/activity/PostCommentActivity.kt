package com.project.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.R
import com.project.databinding.ActivityPostCommentBinding
import com.project.model.remote.dataclass.Comment
import com.project.model.remote.dataclass.Author
import com.project.util.CommentsAdapter

class PostCommentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostCommentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_comment)

        // 임의의 댓글 데이터 생성
        val comments = generateDummyComments()
        setupUI(comments) // 생성한 댓글을 UI에 설정
    }

    private fun generateDummyComments(): List<Comment> {
        val dummyComments = mutableListOf<Comment>()

        for (i in 1..7) {
            val comment = Comment(
                id = i.toString(),
                author = Author(id = i.toString(), name = "저자 $i", profilePictureUrl = "URL"),
                content = "임의 댓글 내용 $i",
                createdAt = "2024-10-01"
            )
            dummyComments.add(comment)
        }
        return dummyComments
    }

    private fun setupUI(comments: List<Comment>) {
        // RecyclerView 설정
        binding.recyclerViewComments.layoutManager = LinearLayoutManager(this)
        val commentsAdapter = CommentsAdapter(comments)
        binding.recyclerViewComments.adapter = commentsAdapter
    }
}

package com.project.view.feedback

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.databinding.ActivityFeedbackListItemBinding
import com.project.model.remote.dataclass.FeedbackList

class FeedbackAdapter(
    private val context: Context,
    private val feedbacks: MutableList<FeedbackList>
) : RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>() {

    inner class FeedbackViewHolder(private val binding: ActivityFeedbackListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(feedback: FeedbackList) {
            binding.textViewTitle.text = feedback.title
            binding.textViewAuthor.text = feedback.author
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        val binding = ActivityFeedbackListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedbackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        holder.bind(feedbacks[position])
    }

    override fun getItemCount(): Int = feedbacks.size

    fun setFeedbacks(newFeedbacks: List<FeedbackList>) {
        feedbacks.clear()
        feedbacks.addAll(newFeedbacks)
        notifyDataSetChanged()
    }

    fun addFeedbacks(newFeedbacks: List<FeedbackList>) {
        feedbacks.addAll(newFeedbacks)
        notifyDataSetChanged()
    }
}

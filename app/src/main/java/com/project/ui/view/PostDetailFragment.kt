package com.project.ui.view//package com.project.view.post.detail
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.project.databinding.FragmentPostDetailBinding
//import com.project.model.remote.dataclass.GetPostDetailResponse
//
//class PostDetailFragment : Fragment() {
//
//    private var _binding: FragmentPostDetailBinding? = null
//    private val binding get() = _binding!!
//
//    companion object {
//        private const val ARG_POST = "post_data"
//
//        fun newInstance(post: GetPostDetailResponse): PostDetailFragment {
//            val fragment = PostDetailFragment()
//            val args = Bundle()
//            args.putSerializable(ARG_POST, post) // PostDetailResponse가 Serializable인 경우
//            fragment.arguments = args
//            return fragment
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentPostDetailBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val post = arguments?.getSerializable(ARG_POST) as? GetPostDetailResponse
//        post?.let { setupUI(it) }
//    }
//
//    private fun setupUI(post: GetPostDetailResponse) {
//        binding.textViewTitle.text = post.title
//        binding.textViewAuthor.text = post.author
//        binding.textViewContent.text = post.content
//        binding.textViewLikes.text = "${post.likes} likes"
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}

//package com.project.view.loading
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.project.databinding.FragmentLoadingBinding
//import com.project.model.remote.dataclass.GetLoadingPost
//
//
//class LoadingFragment : Fragment() {
//
//    private var _binding: FragmentLoadingBinding? = null
//    private val binding get() = _binding!!
//
//    private lateinit var post: GetLoadingPost
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            post = it.getParcelable(ARG_POST)!!
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View {
//        _binding = FragmentLoadingBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.textViewTitle.text = post.title
//        binding.textViewAuthor.text = post.author.toString()
//        binding.textViewId.text = "ID: ${post.id}"
//        binding.textViewLikes.text = "Likes: ${post.likes}"
//        binding.textViewContent.text = post.content
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    companion object {
//        private const val ARG_POST = "post"
//
//        @JvmStatic
//        fun newInstance(post: GetLoadingPost) =
//            LoadingFragment().apply {
//                arguments = Bundle().apply {
//                    putParcelable(ARG_POST, post)
//                }
//            }
//    }
//}

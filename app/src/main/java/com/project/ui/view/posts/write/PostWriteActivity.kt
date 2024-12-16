//package com.project.view.post.write
//
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.widget.doOnTextChanged
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.Observer
//import com.project.R
//import com.project.databinding.ActivityPostWriteBinding
//
//class PostWriteActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityPostWriteBinding
//    private val viewModel: PostWriteViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_write)
//
//        // 제목과 내용 EditText 바인딩
//        binding.editTextTitle.doOnTextChanged { text, _, _, _ ->
//            viewModel.setTitle(text.toString())
//        }
//        binding.editTextContent.doOnTextChanged { text, _, _, _ ->
//            viewModel.setContent(text.toString())
//        }
//
//        binding.buttonSave.setOnClickListener {
//            viewModel.savePost()
//        }
//
//        // 성공 메시지 관찰
//        viewModel.saveSuccess.observe(this, Observer { success ->
//            if (success) {
//                Toast.makeText(this, "Post saved successfully", Toast.LENGTH_SHORT).show()
//                finish()  // 게시글 저장 후 액티비티 종료
//            }
//        })
//
//        // 오류 메시지 관찰
//        viewModel.errorMessage.observe(this, Observer { message ->
//            message?.let {
//                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//}
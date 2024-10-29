package com.project.view.post.write

import android.os.Bundle
import android.text.InputType
import android.text.method.ScrollingMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.project.R
import com.project.databinding.ActivityPostWriteBinding

class PostWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostWriteBinding
    private val viewModel: PostWriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_write)

        // ViewModel의 내용을 EditText에 바인딩
        viewModel.content.observe(this, Observer { content ->
            binding.editTextContent.setText(content)
        })

        // 내용 EditText 스크롤 가능하도록 설정
        binding.editTextContent.movementMethod = ScrollingMovementMethod()

        binding.buttonCenter.setOnClickListener {
            alignContent("center")
        }

        binding.buttonVertical.setOnClickListener {
            enableVerticalWriting()
        }

        binding.buttonLeft.setOnClickListener {
            alignContent("left")
        }

        // 작성 중인 내용을 ViewModel에 저장
        binding.editTextContent.doOnTextChanged { text, _, _, _ ->
            viewModel.setContent(text.toString())
        }

        // 예시: 저장 버튼 클릭 시 ViewModel에서 저장 처리
        binding.buttonSave.setOnClickListener {
            viewModel.savePost()
        }
    }

    private fun alignContent(alignment: String) {
        when (alignment) {
            "center" -> binding.editTextContent.gravity = android.view.Gravity.CENTER
            "left" -> binding.editTextContent.gravity = android.view.Gravity.START
        }
    }

    private fun enableVerticalWriting() {
        binding.editTextContent.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
    }
}

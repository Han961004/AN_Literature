package com.project.view.activity

import android.os.Bundle
import android.text.InputType
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.project.R
import com.project.databinding.ActivityPostWriteBinding

class PostWriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_write)

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
    }

    private fun alignContent(alignment: String) {
        when (alignment) {
            "center" -> binding.editTextContent.gravity = android.view.Gravity.CENTER
            "left" -> binding.editTextContent.gravity = android.view.Gravity.START
        }
    }

    private fun enableVerticalWriting() {
        // 세로쓰기 활성화 로직 구현 (예: 글자를 세로로 배열하기 위해 다른 방식의 EditText 사용)
        // 현재는 그냥 Toast 메시지로 대체
        binding.editTextContent.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
    }
}

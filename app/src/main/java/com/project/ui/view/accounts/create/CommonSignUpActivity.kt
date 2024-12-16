package com.project.ui.view.accounts.create

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.project.databinding.ActivitySignUpBinding
import com.project.view.accounts.login.CommonSignInActivity


/*
* Activity: UI 요소와 상호작용하고 사용자 입력을 처리하는 역할을 합니다.
* 예를 들어, 버튼 클릭 이벤트를 처리하고 UI 요소를 업데이트하는 작업을 담당합니다.
 */

class CommonSignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: com.project.ui.view.accounts.create.CommonSignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObservers()
        signUpBtn()
    }

    /*
    * 뷰 모델 관측 값
     */
    private fun setUpObservers() {
        viewModel.signUpSuccess.observe(this, Observer { success ->
            if (success) {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                Log.d("testt", "회원가입 성공")
                startActivity(Intent(this, CommonSignInActivity::class.java))
                finish()
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            Log.e("testt", "회원가입 실패: $message")
        })
    }

    /* UI 
    * 회원 가입 필드를 입력 후, 
    * ViewModel 로 보냄
    * 확인 후 Bool 값을 위 setUpObservers 에 전송
     */
    private fun signUpBtn() {
        binding.buttonSignUp.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val nickname = binding.editTextNickname.text.toString()

            Log.d("testt", "입력된 username: $username, email: $email, password: $password, nickname: $nickname")

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && nickname.isNotEmpty()) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "올바른 이메일 형식을 입력하세요.", Toast.LENGTH_SHORT).show()
                    Log.w("testt", "유효하지 않은 이메일 형식: $email")
                }
                viewModel.signUp(username, email, password, nickname)
            } else {
                Toast.makeText(this, "모든 필드를 입력하세요.", Toast.LENGTH_SHORT).show()
                Log.w("testt", "모든 필드가 입력되지 않음")
            }
        }
    }


}

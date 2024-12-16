//package com.project.ui.view
//
//import androidx.fragment.app.Fragment
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.viewModels
//import com.project.R
//import com.project.ui.viewmodel.MainViewModel
//
//class MainHomeFragment : Fragment() {
//
//    // UserViewModel을 Fragment에서 사용할 수 있도록 설정
//    private val mainViewModel: MainViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        // LiveData를 관찰하여 유저 정보가 변경되면 UI 업데이트
//
//    }
//}

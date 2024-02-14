package com.solution.gdsc.ui.home

import androidx.navigation.fragment.findNavController
import com.solution.gdsc.R
import com.solution.gdsc.base.BaseFragment
import com.solution.gdsc.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun setLayout() {
        with(binding) {
            btnAiDiagnosis.setOnClickListener {
                // ai 진단
            }
            btnBasicCapture.setOnClickListener {
                //dispatchTakePictureIntent()
                val action = HomeFragmentDirections.actionHomeToCamera()
                findNavController().navigate(action)
            }
            btnUseGuide.setOnClickListener {
                // 이용 방법
            }
        }
    }
}
package com.ej.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ej.domain.utils.ErrorType
import com.ej.domain.utils.ScreenState
import com.ej.presentation.R
import com.ej.presentation.base.BaseFragment
import com.ej.presentation.databinding.FragmentManNameBinding
import com.ej.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view:View){
        binding.loading.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "fa47ec7a06mshc8e4b0b017d1e3ep10dc21jsn534ca665cc45",
            binding.nameEditText.text.toString(),
            mainViewModel.womanNameResult
        )
    }
    private fun observeViewModel(){
        mainViewModel.apiCallEvent.observe(this){
            binding.loading.visibility = View.INVISIBLE
            when (it) {
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR ->toastErrorMsg()
                else -> shortShowToast("알수없는 오류가 발생하였습니다")
            }
        }

    }
    private fun toastErrorMsg() {
        when (mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("호출 시간이 초과되었습니다")
            ErrorType.SESSION_EXPIRED -> longShowToast("예기치 못한 오류가 발생하였습니다.")
        }
    }


}
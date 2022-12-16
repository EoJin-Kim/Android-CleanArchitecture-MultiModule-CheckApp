package com.ej.presentation.view

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ej.presentation.R
import com.ej.presentation.base.BaseFragment
import com.ej.presentation.databinding.FragmentResultBinding
import com.ej.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        initResult()
    }

    private fun initResult() {
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()

        when (mainViewModel.apiCallResult.percentage) {
            in 0..20 ->setLoveMsgTxt("조금 힘들어 보여요")
            in 21..40 ->setLoveMsgTxt("노력해 보세요")
            in 41..60 ->setLoveMsgTxt("기대해도 좋아요")
            in 61..80 ->setLoveMsgTxt("일단 축하드려요")
            in 81..99 ->setLoveMsgTxt("와우.. 눈을 의심하고 있어요")
            100 ->{
                saveStatistics()
                setLoveMsgTxt("완벽하네요 축하드려요")
            }
            else -> setLoveMsgTxt("알수없는 힘")
        }
    }

    private fun saveStatistics() {
        mainViewModel.getStatistics()
            .addOnSuccessListener {
                if (it != null) {
                    mainViewModel.setStatistics(it.value.toString().toInt() + 1)
                        .addOnFailureListener {
                            error()
                        }
                }
            }
            .addOnFailureListener {
                error()
            }
    }

    private fun error() = shortShowToast("통계를 저장하는데 오류가 발생했습니다")

    private fun setLoveMsgTxt(msg: String) {
        binding.message.text =msg

    }

    fun backMainBtnClick(view:View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}
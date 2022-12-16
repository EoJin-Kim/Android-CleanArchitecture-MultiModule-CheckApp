package com.ej.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ej.presentation.R
import com.ej.presentation.base.BaseFragment
import com.ej.presentation.databinding.FragmentMainBinding
import com.ej.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun init() {
        binding.fragment= this
        observeViewModel()
        mainViewModel.getStatiscsDisplay()
    }

    fun startBtnClick(view:View){
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }
    private fun observeViewModel() {
        mainViewModel.getStatisticsEvent.observe(this) {
            binding.statistics.text = it.toString()
        }
    }
}
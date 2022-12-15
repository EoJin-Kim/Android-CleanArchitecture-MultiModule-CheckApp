package com.ej.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ej.presentation.R
import com.ej.presentation.base.BaseFragment
import com.ej.presentation.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {

    override fun init() {
        binding.fragment = this
    }

    fun backMainBtnClick(view:View){
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }
}
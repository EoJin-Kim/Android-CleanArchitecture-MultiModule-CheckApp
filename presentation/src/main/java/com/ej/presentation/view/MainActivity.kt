package com.ej.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ej.presentation.R
import com.ej.presentation.base.BaseActivity
import com.ej.presentation.databinding.ActivityMainBinding
import com.ej.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {

    }
}
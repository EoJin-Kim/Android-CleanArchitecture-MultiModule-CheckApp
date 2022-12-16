package com.ej.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ej.presentation.R
import com.ej.presentation.base.BaseActivity
import com.ej.presentation.databinding.ActivitySplashBinding
import com.ej.presentation.viewmodel.MainViewModel
import com.ej.presentation.viewmodel.SplashViewModel
import com.ej.presentation.widget.extension.startActivityAndFinish
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val splashViewModel by viewModels<SplashViewModel>()
    private val appVersion = "1.0.0"

    override fun init() {
        splashViewModel.checkAppVersion()
            .addOnSuccessListener {
                if (appVersion == it.value) {
                    this.startActivityAndFinish(this,MainActivity::class.java)
                } else {
                    longShowToast("앱버전이 다릅니다!")
                }
            }
            .addOnFailureListener{
                shortShowToast("오류가 발생했습니다. 오류코드 - ${it.message}")
            }


    }

}
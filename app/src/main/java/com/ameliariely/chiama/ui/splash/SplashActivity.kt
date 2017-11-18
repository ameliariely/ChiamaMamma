package com.ameliariely.chiama.ui.splash

import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.ameliariely.chiama.BR
import com.ameliariely.chiama.CallMomApp
import com.ameliariely.chiama.ui.main.MainActivity
import com.ameliariely.chiama.R
import com.ameliariely.chiama.ui.base.BaseActivity


class SplashActivity : BaseActivity<ViewDataBinding, SplashViewModel>(), SplashNavigator {

    override var viewModel: SplashViewModel = SplashViewModel((application as CallMomApp).dataManager)

    override val layoutId = R.layout.activity_splash

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        viewModel.navigateToNextActivity()
    }

    override fun openOnboardingActivity() {
        //TODO make new activity
        val intent = Intent(applicationContext, MovementChooserActivity::class.java)
        intent.putExtra(resources.getString(R.string.inOnboarding), true)
        startActivity(intent)
        finish()
    }

    override fun openMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

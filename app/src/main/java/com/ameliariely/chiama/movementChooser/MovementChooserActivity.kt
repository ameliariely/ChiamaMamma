package com.ameliariely.chiama.splash

import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.util.Log
import com.ameliariely.chiama.BR
import com.ameliariely.chiama.MainActivity
import com.ameliariely.chiama.R
import com.ameliariely.chiama.base.BaseActivity


class MovementChooserActivity : BaseActivity<ViewDataBinding, MovementChooserViewModel>(), SplashNavigator {

    override var viewModel: MovementChooserViewModel = MovementChooserViewModel()

    override val layoutId = R.layout.activity_movement_chooser

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        viewModel.navigateToNextActivity()
        Log.i("amelia", "I splashed!")
    }

    override fun openSetUpActivity() {
        //TODO make new activity
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}

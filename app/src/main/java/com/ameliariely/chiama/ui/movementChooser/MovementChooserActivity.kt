package com.ameliariely.chiama.ui.splash

import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.ameliariely.chiama.BR
import com.ameliariely.chiama.CallMomApp
import com.ameliariely.chiama.R
import com.ameliariely.chiama.R.layout.activity_movement_chooser
import com.ameliariely.chiama.ui.base.BaseActivity
import com.ameliariely.chiama.ui.main.MainActivity

class MovementChooserActivity : BaseActivity<ViewDataBinding, MovementChooserViewModel>(), MovementChooserNavigator {

    override var viewModel: MovementChooserViewModel = MovementChooserViewModel((application as CallMomApp).dataManager)

    override val layoutId = activity_movement_chooser

    override val bindingVariable = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        //TODO doublecheck if this gets the right intent
        //TODO add a datamanager to give this too
        viewModel.inOnboarding.set(
                intent.getBooleanExtra(
                        resources.getString(R.string.inOnboarding),
                        false))
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

interface MovementChooserNavigator {

    fun openSetUpActivity()
    fun openMainActivity()

}




package com.ameliariely.chiama.splash

import com.ameliariely.chiama.base.BaseViewModel

class MovementChooserViewModel : BaseViewModel<SplashNavigator>() {

    fun navigateToNextActivity() {
        if (true) {
            //TODO if app has never been opened
            navigator?.openSetUpActivity()
        } else {
            navigator?.openMainActivity()
        }
    }

}

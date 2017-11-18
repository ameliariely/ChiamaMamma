package com.ameliariely.chiama.splash

import com.ameliariely.chiama.DataManager
import com.ameliariely.chiama.base.BaseViewModel

class SplashViewModel(override val dataManager: DataManager) : BaseViewModel<SplashNavigator>() {

    fun navigateToNextActivity() {
        if (true) {
            //TODO if app has never been opened
            navigator?.openOnboardingActivity()
        } else {
            navigator?.openMainActivity()
        }
    }

}

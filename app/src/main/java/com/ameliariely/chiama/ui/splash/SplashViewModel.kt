package com.ameliariely.chiama.ui.splash

import com.ameliariely.chiama.data.DataManager
import com.ameliariely.chiama.ui.base.BaseViewModel

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

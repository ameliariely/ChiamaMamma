package com.ameliariely.chiama.splash

import android.databinding.ObservableBoolean
import com.ameliariely.chiama.base.BaseViewModel
import com.ameliariely.chiama.movementChooser.MovementChooserNavigator

class MovementChooserViewModel : BaseViewModel<MovementChooserNavigator>() {

    private fun navigateToNextActivity() {
        if (inOnboarding.get()) {
            //TODO if in onboarding
            navigator?.openSetUpActivity()
        } else {
            navigator?.openMainActivity()
        }
    }

    var inOnboarding = ObservableBoolean()
    //TODO set/get from in shared prefs
    var walkingSelected = ObservableBoolean(false)
    var drivingSelected = ObservableBoolean(false)

    fun onSubmitClicked() {
        //todo write status to shared prefs through dataManager
        navigateToNextActivity()
    }
}

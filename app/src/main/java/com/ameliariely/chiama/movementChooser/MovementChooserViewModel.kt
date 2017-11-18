package com.ameliariely.chiama.splash

import com.ameliariely.chiama.base.BaseViewModel
import com.ameliariely.chiama.movementChooser.MovementChooserNavigator

class MovementChooserViewModel : BaseViewModel<MovementChooserNavigator>() {

    fun navigateToNextActivity() {
        if (inOnboarding) {
            //TODO if in onboarding
            navigator?.openSetUpActivity()
        } else {
            navigator?.openMainActivity()
        }
    }

    var inOnboarding = false
    var walkingSelected = false
    var drivingSelected = false

    fun toggleWalkingSeleted() {
        walkingSelected = !walkingSelected
    }

    fun toggleDrivingSeleted() {
        drivingSelected = !drivingSelected
    }
}

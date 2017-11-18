package com.ameliariely.chiama.ui.splash

import android.databinding.ObservableBoolean
import com.ameliariely.chiama.data.DataManager
import com.ameliariely.chiama.ui.base.BaseViewModel
import com.ameliariely.chiama.ui.movementChooser.MovementChooserNavigator

class MovementChooserViewModel(override val dataManager: DataManager) : BaseViewModel<MovementChooserNavigator>() {

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
package com.ameliariely.chiama

import android.app.Application
import com.ameliariely.chiama.prefs.AppPreferencesHelper

class CallMomApp : Application() {

    val dataManager = AppDataManager(context = applicationContext,
            prefsHelper = AppPreferencesHelper(applicationContext, "TODO FILENAME"))

}
package com.ameliariely.chiama

import android.app.Application
import com.ameliariely.chiama.data.AppDataManager
import com.ameliariely.chiama.data.prefs.AppPreferencesHelper

class CallMomApp : Application() {

    val dataManager = AppDataManager(context = applicationContext,
            prefsHelper = AppPreferencesHelper(applicationContext, "TODO FILENAME"))

}
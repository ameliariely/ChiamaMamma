package com.ameliariely.chiama

import android.content.Context
import com.ameliariely.chiama.prefs.PreferencesHelper

interface DataManager {

}

class AppDataManager(context : Context, prefsHelper: PreferencesHelper) : DataManager {
    //TODO is it weird to keep state here?
    //TODO write to shared prefs when user completes onboarding

}
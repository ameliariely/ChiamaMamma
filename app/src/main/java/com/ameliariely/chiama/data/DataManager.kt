package com.ameliariely.chiama.data

import android.content.Context

interface DataManager {

}

class AppDataManager(context : Context, prefsHelper: PreferencesHelper) : DataManager {
    //TODO is it weird to keep state here?
    //TODO write to shared prefs when user completes onboarding

}
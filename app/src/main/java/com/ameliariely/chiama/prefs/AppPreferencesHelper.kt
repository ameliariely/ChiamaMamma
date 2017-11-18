package com.ameliariely.chiama.prefs

import android.content.Context

class AppPreferencesHelper(context: Context, prefFileName: String) : PreferencesHelper {

    private val mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

}

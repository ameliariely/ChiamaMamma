package com.ameliariely.chiama.data.prefs

import android.content.Context

class AppPreferencesHelper(context: Context, prefFileName: String) : PreferencesHelper {

    private val mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

}

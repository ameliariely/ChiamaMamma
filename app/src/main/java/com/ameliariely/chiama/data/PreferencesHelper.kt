package com.ameliariely.chiama.data

import android.content.Context

interface PreferencesHelper {

}

class AppPreferencesHelper(context: Context, prefFileName: String) : PreferencesHelper {

    private val mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

}


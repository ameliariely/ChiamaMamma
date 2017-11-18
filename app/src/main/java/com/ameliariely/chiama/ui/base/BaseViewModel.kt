package com.ameliariely.chiama.ui.base

import com.ameliariely.chiama.data.DataManager


abstract class BaseViewModel<N> {

    var navigator: N? = null

    abstract val dataManager: DataManager
}

package com.ameliariely.chiama.base

import com.ameliariely.chiama.DataManager


abstract class BaseViewModel<N> {

    var navigator: N? = null

    abstract val dataManager: DataManager
}

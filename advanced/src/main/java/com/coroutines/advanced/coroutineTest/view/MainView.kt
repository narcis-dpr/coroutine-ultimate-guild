package com.coroutines.advanced.coroutineTest.view

import com.coroutines.advanced.coroutineTest.model.User
import com.coroutines.advanced.coroutineTest.presentation.MainPresenter
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainView(
    private val presenter: MainPresenter,
) {

    var userData: User? = null

    @OptIn(DelicateCoroutinesApi::class)
    fun fetchUserData() {
        GlobalScope.launch(Dispatchers.IO) {
            userData = presenter.getUser("101")
        }
    }

    fun printUserData() {
        println(userData)
    }
}

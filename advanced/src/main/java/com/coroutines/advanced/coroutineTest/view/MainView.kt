package com.coroutines.advanced.coroutineTest.view

import com.coroutines.advanced.coroutineTest.contextProvider.CoroutineContextProvider
import com.coroutines.advanced.coroutineTest.model.User
import com.coroutines.advanced.coroutineTest.presentation.MainPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainView(
    private val presenter: MainPresenter,
    private val contextProvider: CoroutineContextProvider,
    private val coroutineScope: CoroutineScope,
) {

    var userData: User? = null

    /**
     * Fetch user data:
     * context and scope for coroutine shouldn't be hardcoded so that we can pass
     * any scope that we want : actual scope for actual code and test scope for
     * test code
     *
     */

    fun fetchUserData() {
        coroutineScope.launch(contextProvider.context()) {
            userData = presenter.getUser("101")
        }
    }

    fun printUserData() {
        println(userData)
    }
}

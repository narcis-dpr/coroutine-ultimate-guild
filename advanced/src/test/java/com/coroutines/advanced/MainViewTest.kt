package com.coroutines.advanced

import com.coroutines.advanced.coroutineTest.presentation.MainPresenter
import com.coroutines.advanced.coroutineTest.view.MainView
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test


class MainViewTest {
    private val mainPresenter by lazy { MainPresenter() }
    private val mainView by lazy { MainView(mainPresenter) }

    @Test
    fun testFetchUserData() {
        // arrange: initial state
        assertNull(mainView.userData)
        //act: updating the state
        mainView.fetchUserData()
        // assert: checking the new state, and printing it out
        assertEquals("Filip", mainView.userData?.name)
        mainView.printUserData()

    }
}
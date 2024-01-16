package com.coroutines.advanced

import com.coroutines.advanced.coroutineTest.presentation.MainPresenter
import com.coroutines.advanced.coroutineTest.view.MainView
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Test

class MainViewTest {
    private val mainPresenter by lazy { MainPresenter() }
    private val mainView by lazy { MainView(mainPresenter) }

    // test coroutineScope and coroutineContext
    private val testCoroutineDispatcher = StandardTestDispatcher() // helps coroutines run immediately
    private val testCoroutineScope = TestScope(testCoroutineDispatcher) // expose all functions to control the CoroutineDispatcher

    @Test
    fun testFetchUserData() = runTest {
        // arrange: initial state
        assertNull(mainView.userData)
        // act: updating the state
        mainView.fetchUserData()
        // assert: checking the new state, and printing it out
        assertEquals("Filip", mainView.userData?.name)
        mainView.printUserData()
    }

    @Test
    fun exampleTest() = runTest {
        // acts like runBlocking but instead of actually delaying the time, it advances the test time
        val deferred = async {
            delay(1_000)
            async {
                delay(1_000)
            }.await()
        }
        deferred.await()
    }
}

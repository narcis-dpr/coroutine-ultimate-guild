package com.coroutines.advanced.coroutineTest.contextProvider

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {

    fun context(): CoroutineContext
}
